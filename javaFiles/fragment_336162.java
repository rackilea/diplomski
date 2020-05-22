Task<Void> task = new Task<Void>( ){
    @Override
    protected Void call() throws Exception {
        while(! isCancelled()){
            doSomething();
        }
        saveData();
        return null;
    }
};