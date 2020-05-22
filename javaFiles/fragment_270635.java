public synchronized void play() {
    while(this.played) {
        try {
            wait();
        } catch (InterruptedException e) {}
    }

    this.played = true;

    // suppose each DJ can play the disk for 2 seconds and then has to yield the fun to others 
    Thread.sleep(2000);
    this.played = false;
    notifyAll();     
}