public class StackSyncProb{
    private volatile int function2;
    private Object lock = new Object();

    public static void main(String[] args){
        StackSyncProb s = new StackSyncProb(3); // function2 starts at 3
        // start function3, which waits
        s.runFunction3();
        // decrement using function1 until hit 0 (in this case, 3 times)
        for(int i = 0; i < 3; i++){
            s.runFunction1();
        }
    }

    public StackSyncProb(int v){
        function2 = v;
    }

    public void runFunction1(){
        new Thread(new Run1()).start();
    }

    public void runFunction3(){
        new Thread(new Run2()).start();
    }

    public class Run1 implements Runnable{
        @Override
        public void run(){
            function1();
        }
        public void function1(){
            try{
            synchronized(lock){
                function2--;
                // Use if statement to check inside function1 instead of in function3
                if(function2 == 0){
                    lock.notifyAll();
                    // After notifying, wait until function3 done
                    lock.wait();
                }
                System.out.println("function1: " + function2);
            }
            }catch(InterruptedException e){}
        }
    }

    public class Run2 implements Runnable{
        @Override
        public void run(){
            function3();
        }
        public void function3(){
            try{
                synchronized(lock){
                    // No while loop
                    lock.wait();
                    Thread.sleep(1000);
                    System.out.println("function3: " + (function2 + 10));
                    // Notify function1 it can complete and print
                    lock.notifyAll();
                }
            }catch(InterruptedException e){
                System.err.println(e);
            }
        }
    }
}