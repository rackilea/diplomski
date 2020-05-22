int size = 10;
System.out.println("generating...");
List<RetriableTask> tasks = new ArrayList<>();
for (int i = 0; i < size; i++) {
    tasks.add(new RetriableTask(i));
}

System.out.println("issuing...");
List<CompletableFuture<Integer>> futures = new ArrayList<>();
for (int i = 0; i < size; i++) {
    futures.add(tasks.get(i).executeAsync());
}

System.out.println("Waiting...");
for (int i = 0; i < size; i++) {
    try {
        CompletableFuture<Integer> future = futures.get(i);
        int result = future.get();
        System.out.println(i + " result is " + result);
    } catch (Exception ex) {
        System.out.println(i + " I got exception!");
    }
}
System.out.println("Done waiting...");