class Demo {
     static ExecutorService executor = Executors.newSingleThreadExecutor();

     public static void main(String[] args) {
          Future<String> result = executor.submit(new Callable<String>() {
               public String call() {
                    //do something
                    return "Task Complete";
               }
          });

          try {
               System.out.println(result.get()); //get() blocks until call() returns with its value
          }catch(Exception e) {
               e.printStackTrace();
          }
     }
}