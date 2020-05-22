class FileStringifierProxy implements FileStringifier {

    private final String fileName;
    private final CountDownLatch startSignal;
    private final CountDownLatch doneSignal;

    public FileStringifierProxy(String filename, CountDownLatch startSignal,
        CountDownLatch doneSignal) {
        this.fileName = filename;
        this.startSignal = startSignal;
        this.doneSignal = doneSignal;
    }

    public void display(final PrintWriter out) {
        System.out.println("Reading " + fileName);
        final SlowFileStringifier slowfilestringifier = new 
 SlowFileStringifier(
            fileName);
        try {
            startSignal.await(); // Wait for start signal from main thread
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        slowfilestringifier.display(out); // Display file content
        doneSignal.countDown(); // Send done signal to main thread
    }

    public String stringify() {
        // TODO Auto-generated method stub
        return null;
    }
 }