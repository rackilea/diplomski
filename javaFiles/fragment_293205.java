private final static int MAX_RETRY_COUNT = 5;

//...

int retryCount = 0;
Object connection = null;

while(true)
{
    try
    {
        connection = getConnection();
        break;
    }
    catch(ConnectionException e)
    {
        if(retryCount > MAX_RETRY_COUNT)
        {
            throw new RuntimeException("Could not execute getConnection().", e);
        }

        try
        {
            TimeUnit.SECONDS.sleep(15);
        }
        catch (InterruptedException ie)
        {
            Thread.currentThread().interrupt();
            // handle appropriately
        }

        // log error, warning, etc.

        retryCount++;
        continue;
    }
}

// now you have a valid connection