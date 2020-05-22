boolean paused = false;

public void pause() {
    paused = true;
}

public synchronized void resume() {
    paused = false;
    this.notify();
}

@Override
protected Void doInBackground() throws Exception {
    while(!isCancelled()) {
        if( paused ) {
            System.out.println("Background paused, waiting for resume");
            try {
                synchronized(this){
                    wait(1000);
                }
            } catch (InterruptedException ex) {
                System.out.println("Background interrupted");
            }
        } else {
            System.out.println("Background running");
            // do a chunk of actual work
        }
    }
    return null;
}