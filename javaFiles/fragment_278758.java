ExecutorService service = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

for (int i = 0; i < files.length; i++) {
    MultiThreadWriter writer = new MultiThreadWriter(files[i]);
    service.submit(writer);
}