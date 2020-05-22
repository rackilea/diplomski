private final static int MAX_RETRY_COUNT = 5;

//...

int retryCount = 0;
int angle = -1;

while(true)
{
    try
    {
        angle = getAngle();
        break;
    }
    catch(NoAngleException e)
    {
        if(retryCount > MAX_RETRY_COUNT)
        {
            throw new RuntimeException("Could not execute getAngle().", e);
        }

        // log error, warning, etc.

        retryCount++;
        continue;
    }
}

// now you have a valid angle