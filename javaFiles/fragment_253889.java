ExecutorService executor = Executors.newFixedThreadPool(2);
    CompletionService<String> compService = new ExecutorCompletionService<>(executor);

    for (int i = 0; i < 2; i++) {
        compService.submit(new Task(i));
    }

    for (int i = 0; i < 2; i++) {
        try {
            String result = compService.take().get();
            System.out.println("RESULT: " + result);
        } catch (ExecutionException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    executor.shutdownNow();