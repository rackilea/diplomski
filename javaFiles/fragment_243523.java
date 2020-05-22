Data dataHolder= null;

    lThread.setLocked(true);
    lThread.run();
        while(lThread.isLocked()){

            try {

                Thread.sleep(3000);
            }
            catch(InterruptedException e){

            }
        }
       dataHolder = lThread.dataHolder;