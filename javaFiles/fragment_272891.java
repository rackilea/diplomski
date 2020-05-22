public void executeBlaALotOfTimes() {
    long before = System.currentTimeMillis();

    Collection<Future<Void>> futures = new ArrayList<Future<Void>>();

    for (int i = 0; i<40000; i++) {
        futures.add(executeBla());
    }

    for (Future<Void> future : futures) {
        future.get();
    }

    long after = System.currentTimeMillis(); 

    System.out.println("Time it took for a lot of bla to execute: " + (after - before) / 1000.0 + " seconds.");
}