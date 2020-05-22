synchronized (listCreatingRunnableObject) {
    if (!listCreatingRunnableObject.getListsDone()) {
        try {
            listCreatingRunnableObject.wait();
        } catch (InterruptedException e) {
            // handle it somehow
        }
    }
}