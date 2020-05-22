long start = System.currentTimeMillis(); 
        long secondsPassed = 0;

        while(!condition && secondsPassed < 10)
        {
            secondsPassed = (System.currentTimeMillis()-start)/1000;
            logger.trace("secondsPassed=" + secondsPassed);

            //Code here


            try 
            {
                Thread.sleep(1000);
            } 

            catch (InterruptedException e) 
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }