ExecutorService es = Executors.newSingleThreadExecutor();

Future<List<Student>> future = es.submit(new Callable<List<Student>>() {
     public List<Student> call() throws Exception {
          // do some work to get this list
     }
};

// do something

// wait for the result.
List<Student> list = future.get();