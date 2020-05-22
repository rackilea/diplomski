Timer t = new Timer();

t.scheduleAtFixedRate(
    new TimerTask()
    {
        public void run()
        {
            System.out.println("3 seconds passed");
        }
    },
    0,      // run first occurrence immediately
    3000);  // run every three seconds