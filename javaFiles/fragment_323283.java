package test;

import java.util.Iterator;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class QueueListTest
{
    // private static final Queue<Integer> numbers = new ConcurrentLinkedQueue<>();

    public static void main(String[] args)
    {
        final Queue<Integer> numbers = new ConcurrentLinkedQueue<>();

        final AtomicInteger insert = new AtomicInteger(0);
        final AtomicInteger output = new AtomicInteger();

        for(int j = 0; j < 100; j++)
        {
            numbers.add(insert.getAndIncrement());
        }

        // print 1 number every 100ms
        Thread t1 = new Thread() {
            public void run()
            {
                Iterator<Integer> iter = numbers.iterator();
                while(iter.hasNext())
                {

                        int first = numbers.peek();
                        int size = numbers.size();
                        int last = first + size - 1;
                        int current = iter.next();

                        System.out.println("list from " + first + " to " + last + " @ " + current);
                        output.set(current);

                    try
                    {
                        Thread.sleep(100);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        // add 5 number every 500ms
        Thread t2 = new Thread() {
            public void run()
            {
                while(true)
                {
                    for(int j = 0; j < 5; j++)
                    {
                        numbers.add(insert.getAndIncrement());
                    }
                    try
                    {
                        Thread.sleep(500);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        };

        // remove all printed numbers every 1000ms
        Thread t3 = new Thread() {
            public void run()
            {
                while(true)
                {
                    try
                    {
                        Thread.sleep(1000);
                    }
                    catch(InterruptedException e)
                    {
                        e.printStackTrace();
                    }

                        int current = output.intValue();

                        while(numbers.peek() < current)
                            numbers.poll();
                }
            }
        };

        t1.start();
        t2.start();
        t3.start();

        try
        {
            t1.join();
            t2.join();
            t3.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }
}