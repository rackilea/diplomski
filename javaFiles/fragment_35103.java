Runnable task = () -> {
        while (!Thread.interrupted()) {
            System.out.println("Executing");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                return;
            }
        }
    };