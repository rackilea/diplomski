Thread tt = new Thread(new Runnable()
    {
        public void run()
        {
            try
            {
                SwingUtilities.invokeAndWait(new Runnable()
                {

                    @Override
                    public void run()
                    {
                        EventQueue.invokeLater(new Runnable() { public void run() {
                            new Loadingframe();

                        }});

                    }
                });
            } catch (InvocationTargetException e)
            {
                e.printStackTrace();
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }

        }
    });