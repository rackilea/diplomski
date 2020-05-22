new Thread(() -> {
    while (true) {
        if (Thread.interrupted()) {
            break;
        }
        System.out.println("Running");
    }
});