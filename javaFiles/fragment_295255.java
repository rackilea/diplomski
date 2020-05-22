executor = Executors.newFixedThreadPool(numprocrssors, new ThreadFactory ( ){
    public Thread newThread(Runnable r) {
        return new Thread(r){
            {calculator.get();} // this is an initialization statement, added to all constructors.
        };
    }});