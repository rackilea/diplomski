while (!interrupted)
 {
         try
         {
            Thread.sleep(1000);
            runOnUiThread(new Runnable() // start actions in UI thread
            {
                @Override
                public void run()
                {
                    // displayData(); // this action have to be in UI thread
                    if(BT_is_connect) bl.sendData(String.valueOf(commandLeft+motorLeft+"\r"+commandRight+motorRight+"\r"));

                }
            });
        }
         catch (InterruptedException e)
        {
             // ooops
        }       
 }