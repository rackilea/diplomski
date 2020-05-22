public static void main(String[] args){
    //scheduler executor is a lot more sophisticated solution
    final ScheduledExecutorService sheduler = Executors.newScheduledThreadPool(1);
    class MyO extends Observable {
        public void trackChanged(){
            setChanged(); //this method is protected in super class
        }
    };
    //must be final because it used in nested class
    final MyO o = new MyO();
    o.addObserver(new Observer() {
        @Override
        public void update(Observable o, Object arg) {
            //your processing here
            System.out.println("update");
            sheduler.shutdown();
        }
    });
    sheduler.schedule(new Runnable() {
        @Override
        public void run() {
            o.trackChanged();
            o.notifyObservers();
        }
    }, 3, TimeUnit.SECONDS); //set any timout
}