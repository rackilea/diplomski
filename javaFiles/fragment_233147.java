class TempWorkflowImpl() {
   private final WorkflowClock clock = decisionContextProvider.getDecisionContext().getWorkflowClock()
   @Override 
   public void execute() {
       new TryCatchFinallly {
             @Override
             protected void doTry() throws Throwable {
                   invoke();
             }
             @Override
             protected void doFinally() throws Throwable {
                    // Clean up code
             }
             @Override
             protected void doCatch() throws Throwable {
                    // Handle Exception
             }                    
       }
   } 

   @Asynchronous
   // On ServiceFailureException retry from the beginning
   @ExponentialRetry(initialRetryIntervalSeconds=300, exceptionsToRetry=ServiceFailureException.class) 
   private Promise<ResultType>  invoke() {
                    Promise<Void> invoked = activityClient.invoke();
                    Promise<ResultType> result = checkResultAfterDelay(invoked);
                    processResult(result);
   }

   @Asynchronous
   private Promise<ResultType>  checkResultAfterDelay(Promise<Void> invoked) {
      Promise<Void> timer = clock.createTimer(TimeUnit.MINUTES.toSeconds(60));
      return checkResult(timer);
   }

   @Asynchronous
   // Automatically retry on ResultUnavailableException
   @ExponentialRetry(initialRetryIntervalSeconds=300, exceptionsToRetry=ResultUnavailableException.class) 
   private Promise<ResultType> checkResult(Promise<Void> timer) {
      return activityClient.checkResult();
   }

   @Asynchronous
   private processResult(Promise<ResultType>  result) {
     ....
   }