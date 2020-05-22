javax.naming.InitialContext ctx = new InitialContext();
   ManagedExecutorService mes = (ManagedExecutorService)
       ctx.lookup("java:comp/env/concurrent/ThreadPool");

   // Create a set of tasks to perform the account retrieval.
   ArrayList<Callable<MyObject>> retrieverTasks = new ArrayList<Callable<MyObject>>();
   retrieverTasks.add(new MyCallable());