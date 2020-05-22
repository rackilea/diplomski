import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
public class Foo
{
    private int[] myArray = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,14};//This array can be of any length.
    private volatile int lastIndex = 0;
    private final Lock lock = new ReentrantLock(true);
    private final Condition condition = lock.newCondition();
    public void increment()
    {
        lock.lock();
        try
        {
            if (isDone())
            {
                return;
            }
            myArray[lastIndex] = myArray[lastIndex]+2;
            System.out.println("Incremented arr["+lastIndex+"] to "+myArray[lastIndex]+" via thread "+Thread.currentThread().getName());
            lastIndex++;
            condition.signal();
            if (!isDone())
            {
                condition.await();
            }
        }
        catch (Exception ex){}
        finally{lock.unlock();}
    }

    public boolean isDone()
    {
        return lastIndex == myArray.length;
    }
    public static void main(String[] args)
    {
       final Foo foo = new Foo();
       Thread th1 = new Thread("Thread1")
        {
           public void run()
            {
               while (!foo.isDone())
               {
                    foo.increment();
               }
            }
        };
        Thread th2 = new Thread("Thread2")
        {
            public void run()
            {
                while (!foo.isDone())
                {
                    foo.increment();
                }
            }
        };
        th2.start();th1.start();
    }
}