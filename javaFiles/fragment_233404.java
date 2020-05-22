public class Task implements Callable<Object> { 

     private Object result;

     public Object call() {
          // compute result
          return result;
     } 
}