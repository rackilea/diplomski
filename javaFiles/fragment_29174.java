private static final long TIMEOUT_MS = 60000;
    Process process = Runtime.getRuntime().exec(command);
    try
    {
        while (true)
        {

            Thread thread1 = new Thread(new ReaderThread(process.getInputStream()));
            Thread thread2 = new Thread(new ReaderThread(process.getErrorStream()));

            thread1.start();
            thread2.start();

            process.waitFor();
            thread1.join(TIMEOUT_MS);
            thread2.join(TIMEOUT_MS);
            ...
        }
    } finally {
        process.destroy();
    }