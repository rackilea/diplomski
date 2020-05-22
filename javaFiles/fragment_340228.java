private static boolean canPlay = true;
private static Object playLock = new Object();

@Override
public void run() {
    checkPlayable();

    try {
        // your code
    }
    finally { // If a exception happens(or not) during the execution of the code block above, lock must be released.
        synchronized (playLock) {
            canPlay = true; // enable playing for others
            playLock.notifyAll(); // wake up others
        }
    }

}

/*
 * This is used to get the lock for the first one to come. Makes other ones wait.
 */
private static void checkPlayable() { 
    synchronized (playLock) {
        while(!canPlay) {
            try {
                playLock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        canPlay = false;
    }

}