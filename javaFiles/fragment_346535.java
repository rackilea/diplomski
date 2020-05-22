private static final int procs = Runtime.getRuntime().availableProcessors();
private final ExecutorService es = new Executors.newFixedThreadPool(procs);

int tasks = ....
int blockSize = (tasks + procss -1) / procs;
List<Future<Results>> futures = new ArrayList<>();

for(int i = 0; i < procs; i++) {
    int start = i * blockSize;
    int end = Math.min(tasks, (i + 1) * blockSize);
    futures.add(es.submit(new Task(start, end));
}

for(Future<Result> future: futures) {
    Result result = future.get();
    // check/accumulate result.
}