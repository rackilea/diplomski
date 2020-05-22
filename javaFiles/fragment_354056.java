public class BigFileReader implements Runnable {
    private final String fileName;
    private final BlockingQueue<String> linesRead;
    public BigFileReader(String fileName, BlockingQueue<String> linesRead) {
        this.fileName = fileName;
        this.linesRead = linesRead;
    }
    @Override
    public void run() {
        //since it is a sample, I avoid the manage of how many lines you have read
        //and that stuff, but it should not be complicated to accomplish
        Scanner scanner = new Scanner(new File(fileName));
        while (scanner.hasNext()) {
            try {
                linesRead.put(scanner.nextLine());
            } catch (InterruptedException ie) {
                //handle the exception...
                ie.printStackTrace();
            }
        }
        scanner.close();
    }
}

public class BigFileProcessor implements Runnable {
    private final BlockingQueue<String> linesToProcess;
    public BigFileProcessor (BlockingQueue<String> linesToProcess) {
        this.linesToProcess = linesToProcess;
    }
    @Override
    public void run() {
        String line = "";
        try {
            while ( (line = linesToProcess.take()) != null) {
                //do what you want/need to process this line...
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class BigFileWholeProcessor {
    private static final int NUMBER_OF_THREADS = 2;
    public void processFile(String fileName) {
        BlockingQueue<String> fileContent = new LinkedBlockingQueue<String>();
        BigFileReader bigFileReader = new BigFileReader(fileName, fileContent);
        BigFileProcessor bigFileProcessor = new BigFileProcessor(fileContent);
        ExecutorService es = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
        es.execute(bigFileReader);
        es.execute(bigFileProcessor);
        es.shutdown();
    }
}