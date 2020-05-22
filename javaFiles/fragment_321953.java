threads: for (i...) { // loop over all threads
    for(;;) { // recover join on InterruptedException
        try {
            myThread[i].join();
            continue threads; // after successful join
        } catch (InterruptedException e) {} // call join again
    }
}