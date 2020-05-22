package org.springframework.scheduling.concurrent;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.concurrent.ConcurrentTaskExecutor;
import org.springframework.scheduling.concurrent.ExecutorConfigurationSupport;
import org.springframework.scheduling.concurrent.ThreadPoolExecutorFactoryBean;
import org.springframework.util.Assert;

public class ThreadPoolTaskExecutor extends ExecutorConfigurationSupport implements AsyncListenableTaskExecutor, SchedulingTaskExecutor {

    private final Object poolSizeMonitor = new Object();

    private int corePoolSize = 1;

    private int maxPoolSize = Integer.MAX_VALUE;

    private int keepAliveSeconds = 60;

    private int queueCapacity = Integer.MAX_VALUE;

    private boolean allowCoreThreadTimeOut = false;
    //fix
    private CallableTransform callableTransform;

    private ThreadPoolExecutor threadPoolExecutor;


    public void setCorePoolSize(int corePoolSize) {
        synchronized (this.poolSizeMonitor) {
            this.corePoolSize = corePoolSize;
            if (this.threadPoolExecutor != null) {
                this.threadPoolExecutor.setCorePoolSize(corePoolSize);
            }
        }
    }

    public int getCorePoolSize() {
        synchronized (this.poolSizeMonitor) {
            return this.corePoolSize;
        }
    }

    public void setMaxPoolSize(int maxPoolSize) {
        synchronized (this.poolSizeMonitor) {
            this.maxPoolSize = maxPoolSize;
            if (this.threadPoolExecutor != null) {
                this.threadPoolExecutor.setMaximumPoolSize(maxPoolSize);
            }
        }
    }

    public int getMaxPoolSize() {
        synchronized (this.poolSizeMonitor) {
            return this.maxPoolSize;
        }
    }

    public void setKeepAliveSeconds(int keepAliveSeconds) {
        synchronized (this.poolSizeMonitor) {
            this.keepAliveSeconds = keepAliveSeconds;
            if (this.threadPoolExecutor != null) {
                this.threadPoolExecutor.setKeepAliveTime(keepAliveSeconds, TimeUnit.SECONDS);
            }
        }
    }

    public int getKeepAliveSeconds() {
        synchronized (this.poolSizeMonitor) {
            return this.keepAliveSeconds;
        }
    }

    public void setQueueCapacity(int queueCapacity) {
        this.queueCapacity = queueCapacity;
    }

    public void setAllowCoreThreadTimeOut(boolean allowCoreThreadTimeOut) {
        this.allowCoreThreadTimeOut = allowCoreThreadTimeOut;
    }


    //fix
    public void setCallableDecorator(CallableDecorator callableDecorator) {
        Assert.isNull(this.callableTransform, "You can' call setCallableDecorator() and setTaskDecorator() more than once");
        this.callableTransform = new CallableTransform(){

            @Override
            public Callable<?> decorate(Object originalTask) {
                Callable<?> ret = callableDecorator.decorate((Callable<?>)originalTask);
                return ret;
            }

            @Override
            public boolean isCallable(){
                return true;
            }
    };
}

    //fix
    public void setTaskDecorator(TaskDecorator taskDecorator) {
        Assert.isNull(this.callableTransform, "You can' call setCallableDecorator() and setTaskDecorator() more than once");
        this.callableTransform =  new CallableTransform(){

            @Override
            public Callable<?> decorate(Object originalTask) {
                Callable<?> ret= Executors.callable(taskDecorator.decorate((Runnable)originalTask));
                return ret;
            }

            @Override
            public boolean isCallable(){
                return false;
            }
        };
    }


    @Override
    protected ExecutorService initializeExecutor(
            ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {

        BlockingQueue<Runnable> queue = createQueue(this.queueCapacity);

        ThreadPoolExecutor executor;

        //fix
        if (this.callableTransform != null) {
            executor = new ThreadPoolExecutor(
                    this.corePoolSize, this.maxPoolSize, this.keepAliveSeconds, TimeUnit.SECONDS,
                    queue, threadFactory, rejectedExecutionHandler) {

                @Override
                protected <T> RunnableFuture<T> newTaskFor(Callable<T> callable) {
                    if(callableTransform==null){
                        return super.newTaskFor(callable);
                    }

                    Callable<?> wrapedCallable = null;

                    boolean isCallable = callableTransform.isCallable();
                    if(isCallable){
                        wrapedCallable = callableTransform.decorate(callable);
                    } else {
                        //callableTransform accepts Runnable, but we have Callable
                        throw new IllegalStateException("You use TaskDecorator, but submit Callable");
                    }

                    @SuppressWarnings("unchecked")
                    Callable<T> param = (Callable<T>)wrapedCallable;
                    return super.newTaskFor(param);
                }

                @Override
                protected <T> RunnableFuture<T> newTaskFor(Runnable runnable, T value) {
                    if(callableTransform==null){
                        return super.newTaskFor(runnable, value);
                    }

                    Callable<?> wrapedCallable = null;

                    boolean isRunnable = callableTransform.isRunnable();
                    if(isRunnable){
                        wrapedCallable = callableTransform.decorate(runnable);
                    } else {
                        //callableTransform accepts Callable, but we have Runnable
                        throw new IllegalStateException("You use CallableDecorator, but execute Runnable");
                    }

                    @SuppressWarnings("unchecked")
                    Callable<T> param = (Callable<T>)wrapedCallable;
                    return super.newTaskFor(param);
                }


            };

        } else {
            executor = new ThreadPoolExecutor(
                    this.corePoolSize, this.maxPoolSize, this.keepAliveSeconds, TimeUnit.SECONDS,
                    queue, threadFactory, rejectedExecutionHandler);

        }

        if (this.allowCoreThreadTimeOut) {
            executor.allowCoreThreadTimeOut(true);
        }

        this.threadPoolExecutor = executor;
        return executor;
    }


    protected BlockingQueue<Runnable> createQueue(int queueCapacity) {
        if (queueCapacity > 0) {
            return new LinkedBlockingQueue<>(queueCapacity);
        }
        else {
            return new SynchronousQueue<>();
        }
    }

    public ThreadPoolExecutor getThreadPoolExecutor() throws IllegalStateException {
        Assert.state(this.threadPoolExecutor != null, "ThreadPoolTaskExecutor not initialized");
        return this.threadPoolExecutor;
    }

    public int getPoolSize() {
        if (this.threadPoolExecutor == null) {
            // Not initialized yet: assume core pool size.
            return this.corePoolSize;
        }
        return this.threadPoolExecutor.getPoolSize();
    }

    public int getActiveCount() {
        if (this.threadPoolExecutor == null) {
            // Not initialized yet: assume no active threads.
            return 0;
        }
        return this.threadPoolExecutor.getActiveCount();
    }


    @FunctionalInterface
    public interface CallableDecorator {
        <V> Callable<V> decorate(Callable<V> task);
    }

    @FunctionalInterface
    static interface CallableTransform {
        Callable<?> decorate(Object originalTask);

        default boolean isCallable(){
            return true;
        }

        default boolean isRunnable(){
            return !isCallable();
        }
    }



    //rest of the code execute/submit override
    //...

    @Override
    public boolean prefersShortLivedTasks() {
        return true;
    }

}