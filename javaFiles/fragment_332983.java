private void pauseThread ()
    {
        synchronized (lock)
        {
            if (pause)
                lock.wait(); // Note that this can cause an InterruptedException
        }
    }