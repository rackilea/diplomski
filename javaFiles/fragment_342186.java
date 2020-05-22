public class OuterClass{
    int x,y;
    public void someMethod(){

         final int neededByAnonymousClass = x + y + 30;

         Runnable runnable = new Runnable(){
              // This is like we are creating a class which simply implements Runnable interface.
              // Scope of this class is inside the method someMethod()
              // run() method may be executed sometime later after the execution of someMethod() has completed.
             // all the local variables needs to be final in order they can be used later in time when run() gets executed.

             public void run(){
                 System.out.println(neededByAnonymousClass+ 40);
             }
         }
         Thread thread = new Thread(runnable); // passing the object of anonymous class, created above
         thread.start();
    }
}