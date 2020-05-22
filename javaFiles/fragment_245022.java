mainframe.addWindowListener(new java.awt.event.WindowAdapter() {

        @Override
        public void windowClosing(WindowEvent winEvt) {
            closeEXES();
        }
    });

    if (System.getProperty("os.name").equals("Mac OS X"))
    {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                System.out.println("in : run () : shutdownHook");
                doCloses();
                System.out.println("Shutdown hook completed...");
            }
        });
    }