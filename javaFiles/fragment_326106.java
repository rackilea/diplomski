Thread[] threads = new Thread[10];
for(int i = 0; i < threads.length; i++) { 
    threads[i] = new Thread(this); 
    threads[i].start(); 
}

// Wait for all of the threads to finish.
for (Thread thread : threads)
    thread.join();