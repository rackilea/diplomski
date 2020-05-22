//wait for all threads to finish
try {
    thread1.join();
    thread2.join();
    thread3.join();
} catch (InterruptedException e) {
    e.printStackTrace();
}