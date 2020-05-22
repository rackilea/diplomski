Lock channelActive = new ReentrantLock();

public void test() {
    channelActive.lock();
    try {
        // Do your exclusive stuff here.
    } finally {
        channelActive.unlock();
    }

}