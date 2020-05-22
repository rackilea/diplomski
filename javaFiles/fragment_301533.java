private boolean stopped;

public void run() {
    while(!stopped) {
        //do some work
    }
}

public void pleaseStop() {
    stopped = true;
}