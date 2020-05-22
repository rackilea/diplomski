public void testExecutor(){
    Runnable incr = ()->{
        //System.out.println("count="+count);
        synchronized(this){
            try {
                Thread.sleep(10);
            catch (InterruptedException e){}
            count++;    
        }
    };