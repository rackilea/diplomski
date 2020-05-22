for (int i = 1; i <= cores; i++){
    final int iFinal = i;

    exec.execute(new Runnable(){

        public void run(){
            ready.countDown();
            try{
                start.await();
                System.out.println( "i=" + iFinal );
            } catch (InterruptedException e){
                Thread.currentThread().interrupt();
            } finally{
                done.countDown();
                exec.shutdown();
            }
        }
    });
}