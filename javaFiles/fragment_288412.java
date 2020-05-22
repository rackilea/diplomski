class StreamReader extends Thread {

    private AtomicBoolean running = new AtomicBoolean(false);
    private InputStream in;
    private OutputStream out;

    public StreamReader(InputStream in, OutputStream out) {
        this.in = in;
        this.out = out;
        running.set(true);
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(in);
        PrintWriter writer = new PrintWriter(out, true);
        while (running.get()) {
            if (scanner.hasNextLine()) {
                writer.println(scanner.nextLine());
            }
        }
        scanner.close();
    }

    public void shutdown() {
        running.set(false);
    }

}