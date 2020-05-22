class SendThread extends Thread{

    boolean gotData = false; //flag to check if data is received.

    @Override
    public void run(){
        while(gotData == false){
            new Runnable() {
                @Override
                public void run(){
                    //SendData code
                    //if you get Data change gotData = true;
                }
            }.run();
            Thread.sleep(3000); //sleep for 3 secs
        }
    }
}