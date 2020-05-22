void goToDestination() throws InterruptedException {
    ...
}

@Override
public void run() {
    try {
        goToDestination();
    } catch(InterruptedException e) {
        // end thread
        return;
    }
}