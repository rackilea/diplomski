//Device Will only search for 1 minute
        for(long stop=System.nanoTime()+TimeUnit.SECONDS.toNanos(1); stop>System.nanoTime();)
        {
            Thread recv = new Thread(new MulticastReceiver());
            recv.start();
            recv.join();
        }
    }
    public static synchronized void addDevice(DeviceDetails device) throws InterruptedException
    {
        ....
        Prepare your desired list here.
        ....
    }
}