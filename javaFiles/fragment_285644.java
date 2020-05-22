synchronized(instanceMutex) {
    while(< condition does not hold >) {
        obj.wait();
    }

    // Perform required actions
}