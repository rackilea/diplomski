final List<A> list = new ArrayList() {{ add(new A()); }};

   void foo() {

      Callable<A> call = new Callable<A> {
          A call() throws Exception
          {
              // do something with the list
              return list.get(0);
          }
       }

       ExecutorService executor = new ScheduledThreadPoolExecutor(1);
       Future<A> future = executor.submit(call);

       System.out.println( future.get() );
    }