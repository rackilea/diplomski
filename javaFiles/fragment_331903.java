Thread t;
t = new Thread(){
    @Override
    public void run(){
        /*...*/
        // this = t
        synchronized(this){
            // This is the same as saying
            // this.wait() or t.wait();
            if (threadSuspended==true) {wait();}
        }
    }
};