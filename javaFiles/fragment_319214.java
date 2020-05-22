new Thread(() -> {
    while (true) {
        try {
            blockingQueue.put(input.readLine());
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}).start();

 new Thread(() -> {
    try {
        while (true) {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String input = blockingQueue.poll();
            input = input == null ? "" : input;
            toClient.println(input);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

}).start();