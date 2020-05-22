for (int i = 0; i < 10; i++) {
    final int x = i;
    futures.add(es.submit(new Runnable() {
        @Override public void run() {
            namePrint(x + "name");
        }
    }));
}