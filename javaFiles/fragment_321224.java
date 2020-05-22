@Override
public void run() {
    try {
        // some logic
        try {
            // some logic that throws InterruptedException
        } catch (InterruptedException e) {
            // here you can either rethrow "e"
            // to be dealt in the outer catch block or
            // reinterrupt the current thread
            throw e;
        }
    } catch (InterruptedException e) {
        // here you cannot rethrow "e"
        // so you have to deal with it or
        // reinterrupt the current thread
    }
}