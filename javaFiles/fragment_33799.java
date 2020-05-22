@Override
public void run() {
    while(true) {
        try {
            goToDestination(destination);
        } catch (InterruptedException e) {
            // try again with changed destination
        }
    }
}