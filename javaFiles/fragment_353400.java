int size = 10;
Thread[] threads = new Thread[size];
Work[] works = new Work[size];
for (int i = 1; i <= size; i++) {

    Work w = new Work();
    works[i - 1] = w;
    Thread t = new Thread(w);
    threads[i - 1] = t;

    // Start the thread
    t.start();
}
// now you have started all the threads


for (int i = 0; i < size; i++) {

    // wait for each thread to complete execution, before extracting the result
    // [here i am assuming that getResultFromThread() does not block
    // till we get the result, if it blocks, then no need to join]
    threads[i].join();

    int result = works[i].getResultFromThread();
    // do something with the result
}