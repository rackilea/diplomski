Task<Void> task = new Task<Void>( ){
    @Override
    protected Void call() throws Exception {
        while(! isCancelled()){
            try {
                doSomething();
            } catch (InterruptedException exc) {
                if (isCancelled()) {
                    break ;
                }
            }
        } 

        saveData();
        return null;
    }
};