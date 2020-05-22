public Boolean call() throws IOException, InterruptedException, ExecutionException, TimeoutException {
    Process p = Runtime.getRuntime().exec(mFilename);
    final BufferedReader input = new BufferedReader
            (new InputStreamReader(p.getInputStream()));
    final BufferedWriter output = new BufferedWriter
            (new OutputStreamWriter(p.getOutputStream()));
    output.write(Integer.toString(mParam));
    output.newLine();
    output.flush();

    ExecutorService executor = Executors.newFixedThreadPool(2);
    Callable<Character> readTask = new Callable<Character>() {
        @Override
        public Character call() throws Exception {
            return Character.valueOf((char)input.read());
        }
    };
    Future<Character> future = executor.submit(readTask);
    char readVal;
    try {
        readVal = future.get(3L, TimeUnit.SECONDS);
    } finally {
        p.destroy();
        executor.shutdownNow();
    }

    return !(readVal == '0');
}