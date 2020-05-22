AePlayWave apw = new AePlayWave("test.wav");
    apw.start();

    try{
        boolean alive = apw.isAlive();
        while(alive){
            //check periodically if the thread is alive         
            alive = apw.isAlive();
            Thread.currentThread().sleep(500);

            }

    }

    catch(InterruptedException e){
        System.out.println("Interrupted");
        e.printStackTrace();
    }

//do other action..