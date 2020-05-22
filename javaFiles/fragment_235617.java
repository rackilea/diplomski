Thread t1 = new Thread(){
    @Override
    public void run()
    {
        // Your Code goes here run
    }
    };

    Thread t2 = new Thread(){
    @Override
    public void run()
    {
        // Your Code goes here runner2
    }
    };

    t1.start();
    t2.start();