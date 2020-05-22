public class CallableDecorator implements Callable {

       IRunnable r;

       public CallableDecorator(IRunnable r) {

           this.r = r;
       }

       public Integer call() {

           r.run();
           return r.statusCode();
       }
}

interface IRunnable extends Runnable {
     public Integer statusCode();
}