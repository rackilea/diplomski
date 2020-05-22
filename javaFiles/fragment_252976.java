void solve(Executor e, Collection<Callable<Result>> solvers)
     throws InterruptedException, ExecutionException {
       CompletionService<Result> ecs
           = new ExecutorCompletionService<Result>(e);
       for (Callable<Result> s : solvers)
           ecs.submit(s);
       int n = solvers.size();
       for (int i = 0; i < n; ++i) {
           Result r = ecs.take().get();
           if (r != null)
               use(r);
       }
   }