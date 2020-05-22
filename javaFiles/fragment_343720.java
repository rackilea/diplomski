public class ThreadLocalDemo {


    public static void main(String[] args) {
        testLocal oneInstance = new testLocal();

        Thread A = new Thread(oneInstance);
        Thread B = new Thread(oneInstance);
        Thread C = new Thread(oneInstance);

        A.start();
        try
        {
            Thread.sleep(400);
        }
        catch(InterruptedException e){}

        B.start();
        try
        {
            Thread.sleep(400);
        }
        catch(InterruptedException e){}

        C.start();
        try
        {
            Thread.sleep(400);
        }
        catch(InterruptedException e){}
    }

}

class testLocal implements Runnable
{
    private static final ThreadLocal local = new ThreadLocal<String>(){
        @Override
        protected String initialValue() {
            System.out.println(" local thread initialValue() called ");
            return "intial Value";
        }
    };

    @Override
    public void run() {
        local.set(Thread.currentThread().getName());
        try
        {
            Thread.sleep(2000);
        }
        catch(InterruptedException e){}
        System.out.print(Thread.currentThread().getName() + " run() " );
        System.out.print(" called.... ");
        System.out.println(local.get());
    }

}