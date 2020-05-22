public class Thread1 implements Runnable { 
   // each thread will have it's own copy of test object in this case
   private ThreadLocal<Test> test = new ThreadLocal<Test>();

    public void run() {
        // this line wont affect the others test instance.
        test.set( new Test() );

   }