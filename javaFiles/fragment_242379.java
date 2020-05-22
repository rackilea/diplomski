public void activateNFCThread(){
    Runnable r = new Runnable(){
            @Override
            public void run () {
                 while(isRoot){
                      // what the thread has to do ...
                 }
            }
    };
    Thread nfcCheckThread = new Thread(r);
    nfcCheckThread.setDaemon(true);
    nfcCheckThread.start();
}