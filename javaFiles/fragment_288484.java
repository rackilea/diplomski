public void run() {
    while(true) {
            if (entriesArray.size() == max_size) {
                synchronized (this) {
                    fIsFinishedWithEntries.set(true);
                    notifyAll();
                }
            } else {...}
        }
    }
}