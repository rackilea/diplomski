(new Thread()
{
    public void run()
    {
        while (looping)
        {
            try
            {
                //  Get the important data via TCP (CAN'T be on the UI thread)

                String st1 = tcpClient.getNetwork();
                String st2 = tcpClient.getDiscovery();
            }
            catch (Exception ex)
            { }
            finally
            {
                try
                {
                    //  Redraw the display (HAS TO be on the UI thread)
                    net.runOnUiThread (new Runnable()
                    {
                        @Override
                        public void run()
                        {
                            invalidate();
                        }
                    });
                }
                catch (Exception ex)
                { }

                try { Thread.sleep (2000); }
                catch (InterruptedException e) { }
            }
        }
    }
}).start();