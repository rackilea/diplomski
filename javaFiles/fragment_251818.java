List<Integer> buffet = Collections.synchronizedList(new ArrayList<>());
...
while (true) {
    synchronized (buffet) {
        // perform your operations
    }
}