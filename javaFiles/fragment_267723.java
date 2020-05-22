class Indexer {

   Lock lock = new ReentrantLock();    

    public void index(){
        while(somecondition){
            this.lock.lock();
            try{
                // perform one indexing step
            }finally{
                lock.unlock();
            }
        }
    }

    public Item lookup(){
        this.lock.lock();
        try{
            // perform your lookup
        }finally{
            lock.unlock();
        }
    }
}