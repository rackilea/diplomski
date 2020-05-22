ThreadPoolTaskExecutor threadPoolFactory = new ThreadPoolTaskExecutor();
    threadPoolFactory.setCorePoolSize(4);
    threadPoolFactory.setMaxPoolSize(4);
    threadPoolFactory.setKeepAliveSeconds(0);


    CallableDecorator decorator = new CallableDecorator(){

        @Override
        public <T> Callable<T> decorate(Callable<T> task) {
            return () -> {
                try {
                    return task.call();
                }
                catch (Throwable e) {
                    synchronized (executor) {
                        if (!((MyRunnable) task).failSilent){   //note use of state of original Task
                            log.error("Execution Failure!", e);
                        }
                    }
                    throw e;
                }
            };
        }
    };
    threadPoolFactory.setCallableDecorator(decorator);

    threadPoolFactory.initialize();
    executor = threadPoolFactory.getThreadPoolExecutor();