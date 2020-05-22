if (!ranOnce)
    {
        EventQueue.invokeLater(new Runnable()//this call the run method in a separate thread
        {
            public void run()
            {
                try
                {
                    // for the current instance of Registration, you are setting
                    // the reg variable by calling another instance of Registration => thats not the correct way to do a Singleton
                    reg = new Registration(); 
                    reg.setVisible(true);
                    ranOnce = true;
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });
    }