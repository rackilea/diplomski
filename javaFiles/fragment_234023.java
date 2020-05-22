public class Test {

public Object locker = new Object();
public boolean oneDone = false;

public class MyRunnable2 implements Runnable {
    public void run() {

        System.out.println( "MyRunnable2 started" );

        for ( int c = 0; c < 50; ++c ) {
            synchronized( locker ) {
                System.out.println( "r2: " + ( c ) );
                locker.notify();
                if(c == 49) {
                    oneDone = true;
                }

                try {
                    if(!oneDone) {
                        locker.wait();
                    }
                } catch ( java.lang.InterruptedException e ) {
                    System.out.println( "e: " + e );
                }                    
            }
        }
    }
}

public class MyRunnable1 implements Runnable {
    public void run() {
        System.out.println( "MyRunnable1 started" );

        for ( int c = 0; c < 50; ++c ) {
            synchronized( locker ) {
                System.out.println( "r1: " + ( c ) );
                locker.notify();
                if(c == 49) {
                    oneDone = true;
                }

                try {
                    if(!oneDone) {
                        locker.wait();
                    }
                } catch ( java.lang.InterruptedException e ) {
                    System.out.println( "e: " + e );
                }
            }
        }
    }
}


public Object sequenceLock = new Object();
public boolean sequence = true;

public class MyRunnableOrdered implements Runnable {

    private final boolean _match;

    public MyRunnableOrdered(boolean match) 
    {
        _match = match;
    }

    public void run() {
        System.out.println( "MyRunnable1 started" );

        for ( int c = 0; c < 50; ++c ) {
            synchronized( sequenceLock ) {
                while(_match != sequence) {
                    try {
                        sequenceLock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                System.out.println( "r" + _match + ":" + ( c ) );
                sequence = !sequence;
                sequenceLock.notify();
            }
        }
    }
}    


public static void main(String[] args) {
    Test t = new Test();
    t.test();
}

public void test() {
    MyRunnable1 r1 = new MyRunnable1();
    MyRunnable2 r2 = new MyRunnable2();
    Thread t1 = new Thread( r1 );
    Thread t2 = new Thread( r2 );


    synchronized( locker ) {
        t1.start();
        t2.start();
    }


    try {
        t1.join();
        t2.join();
    } catch ( java.lang.InterruptedException e ) {
        System.out.println( "e: " + e );
    }

    System.out.println("Done part 1");

    MyRunnableOrdered o1 = new MyRunnableOrdered(true);
    MyRunnableOrdered o2 = new MyRunnableOrdered(false);
    synchronized(sequenceLock) {
        sequence = true;
    }
    Thread to1 = new Thread( o1 );
    Thread to2 = new Thread( o2 );
    to1.start();
    to2.start();

    try {
        to1.join();
        to2.join();
    } catch ( java.lang.InterruptedException e ) {
        System.out.println( "e: " + e );
    }       
    System.out.println("Done part 2");
}
}