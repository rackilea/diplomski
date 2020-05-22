@EnableAsync
public class Application implements AsyncConfigurer {
     @Override Executor getAsyncExecutor(){
      // your ThreadPoolTaskExecutor configuration goes here. 
}


@Override
public AsyncUncaughExceptionHandler getAsyncUncaughtExceptionHandler(){
   return new AsyncExceptionHandler();
}