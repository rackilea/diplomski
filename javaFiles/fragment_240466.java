if (acc1.getAccountNumber().compareTo(acc2.getAccountNumber()) < 0) {
    synchronized (acc1) {
        synchronized (acc2) {
            // do transfer
    }
} else {
    synchronized (acc2) {
        synchronized (acc1) {
            // do transfer
        }
    }
}