t.setOnSucceeded(evt -> System.out.println(t.getValue()));
t.setOnFailed(evt -> {
    System.err.println("The task failed with the following exception:");
    t.getException().printStackTrace(System.err);
});
executorService.submit(t);