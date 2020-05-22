@Async("executorA")
public void methodWithVoidReturnType(String s) {
    .....
}

@Async("executorA")
public Future<String> methodWithSomeReturnType() { 
   ...
   try {
      Thread.sleep(5000);
       return new AsyncResult<String>("hello world !!!!");
   } catch (InterruptedException e) {
      ...
   }

   return null;
}