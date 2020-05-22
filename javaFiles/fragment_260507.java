public synchronized void start(){
    if (running) return;
    running = true;
    //startThread(); (mistake)
    thread = new Thread(this);
    thread.start();
}