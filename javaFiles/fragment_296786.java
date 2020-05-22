import java.util.concurrent.locks.ReentrantLock;

public class MyClass
{
    private volatile MyObject completedResults;
    private final ReentrantLock resultsLock;
    private final ReentrantLock refreshLock;

    public MyClass()
    {
        // This must be a singleton class (such as a servlet) for this to work, since every
        // thread needs to be accessing the same lock.

        resultsLock = new ReentrantLock();
        refreshLock = new ReentrantLock();
    }

    public MyObject myMethodToRequestResults(boolean refresh)
    {
        MyObject resultsToReturn;

        // Serialize access to get the most-recently completed set of results; if none exists,
        // we need to generate it and all requesting threads need to wait.

        resultsLock.lock();

        try
        {
            if (completedResults == null)
            {
                completedResults = generateResults();
                refresh = false; // we just generated it, so no point in redoing it below
            }

            resultsToReturn = completedResults;
        }
        finally
        {
            resultsLock.unlock();
        }

        if (refresh)
        {
            // If someone else is regenerating, we just return the old data and tell the caller that.

            if (!refreshLock.tryLock())
            {
                // create a copy of the results to return, since we're about to modify it on the next line
                // and we don't want to change the (shared) original!

                resultsToReturn = new MyObject(resultsToReturn);  
                resultsToReturn.setSomeoneElseIsRegeneratingTheStuffRightNow(true);
            }
            else
            {
                try
                {
                    completedResults = generateResults();
                    resultsToReturn = completedResults;
                }
                finally
                {
                    refreshLock.unlock();
                }
            }
        }

        return resultsToReturn;
    }
}