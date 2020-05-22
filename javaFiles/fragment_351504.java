public void run(){
    for(int i=1;i<=100;i++){

        System.out.println("THREAD VALUE AFTER 1 SECOND IS: "+i);

        if(i==3){
            Thread.currentThread().interrupt();
            gotoInform();
            break;
        }
        try{
            Thread.currentThread().sleep(1000);
        }
        catch(final Exception e){
            e.printStackTrace();
            if(e instanceof InterruptedException) {
                // just in case this Runnable is actually called directly,
                // rather than in a new thread, don't want to swallow the
                // flag:
                Thread.currentThread().interrupt();
            }
            return;
        }
    }
}