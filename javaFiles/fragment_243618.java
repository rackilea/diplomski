ExecutorService executor = Executors.newFixedThreadPool(10);

Supplier<Integer> call1Supplier = () -> {
    System.out.println("Calling 1");
    try {
        Thread.sleep(100000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return 10;
};

Supplier<Integer> call2Supplier = () -> {
    System.out.println("Calling 1");
    try {
        Thread.sleep(10);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    return 10;
};