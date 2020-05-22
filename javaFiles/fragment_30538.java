import java.util.*;

public class BlockingQueries
{
    public class Pair
    {
        public final String first;
        public final String second;
        public Pair(String first, String second)
        {
            this.first = first;
            this.second = second;
        }
    }

    public class FunkyCollection
    {
        final ArrayList<Pair> pairs = new ArrayList<Pair>();

        public synchronized void add( Pair p )
        {
            pairs.add(p);
            notifyAll();
        }

        public synchronized Pair get( Pair p ) throws InterruptedException
        {
            while (true)
            {
                for (Iterator<Pair> i = pairs.iterator(); i.hasNext(); )
                {
                    Pair pair = i.next();
                    boolean firstOk = p.first == null || p.first.equals(pair.first);
                    boolean secondOk = p.second == null || p.second.equals(pair.second);
                    if (firstOk && secondOk)
                    {
                        i.remove();
                        return pair;                
                    }
                }
                wait();
            }
        }   
    }

    class Producer implements Runnable
    {
        private FunkyCollection funkyCollection;

        public Producer(FunkyCollection funkyCollection)
        {
            this.funkyCollection = funkyCollection;
        }

        public void run()
        {
            try
            {
                for (int i = 0; i < 10; ++i)
                {
                    System.out.println("Adding item " + i);
                    funkyCollection.add(new Pair("foo" + i, "bar" + i));
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
        }
    }

    public void go() throws InterruptedException
    {
        FunkyCollection funkyCollection = new FunkyCollection();
        new Thread(new Producer(funkyCollection)).start();
        System.out.println("Fetching bar5.");
        funkyCollection.get(new Pair(null, "bar5"));
        System.out.println("Fetching foo2.");
        funkyCollection.get(new Pair("foo2", null));
        System.out.println("Fetching foo8, bar8");
        funkyCollection.get(new Pair("foo8", "bar8"));
        System.out.println("Finished.");
    }

    public static void main(String[] args) throws InterruptedException
    {
        new BlockingQueries().go();
    }
}