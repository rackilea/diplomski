Future<?> futureA = ses1.scheduleAtFixRate(..) // for thread 1  
Future<?> futureB = ses2.scheduleAtFixRate(..) // for thread 2
submitAndStopTheApplicationIfFail(futureA);
submitAndStopTheApplicationIfFail(futureB);

public void submitAndStopTheApplicationIfFail(Future<?> future){
      executor.submit(() -> {
      try {
        future.get();
      } catch (InterruptedException e) {
        // stop the application
      } catch (ExecutionException e) {
        // stop the application
      }
    });
}