public void saveAndClearQueue() {
    List<String> suiteNames = new ArrayList<String>();
    synchronized (queue) {
        for (String suite : queue) {
            suiteNames.add(suite);
        }
        queue.clear();
    }
    System.out.println("Saved(not executed) : "+suiteNames);
}