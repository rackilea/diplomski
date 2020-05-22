mUEHandler = new Thread.UncaughtExceptionHandler()
        {
            @Override
            public void uncaughtException(Thread t, Throwable e)
            {
                // Close any opened sockets here

                defaultUEH.uncaughtException(t, e);
            }
        };

        Thread.setDefaultUncaughtExceptionHandler(mUEHandler);