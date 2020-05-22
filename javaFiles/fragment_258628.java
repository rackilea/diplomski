class SimpleConsumer extends Threads {
    private final SyncQueue q;

    SimpleConsumer(SyncQueue q) {
        this.q = q;
    }

    public void doit() {
        while(true){
            try{
                synchronized(q) {
                    while(q.isEmpty()) { q.wait(); }
                    System.out.println((String)q.Dequeue());
                }
            } 
            catch (Exception e) { System.out.println("Got exception:" +e); }
        }
    }    
}