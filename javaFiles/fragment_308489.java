public void run(){
while(!Stop){
    view.callMethod();
    try {
        Thread.sleep(5);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}