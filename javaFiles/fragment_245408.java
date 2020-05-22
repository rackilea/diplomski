public static void main(String[] args) {
    if (args.length != 1) {
        System.out.println("Usage: java ShowFileContents <directory>");
    }

    String dirname = args[0];

    File dir = new File(dirname);
    if (!dir.exists()) {
        System.err.println(dirname + " does not exist");
        return;
    }
    if (!dir.isDirectory()) {
        System.err.println(dirname + " is not a directory");
        return;
    }

    File[] files = dir.listFiles();
    int noOfFilesToProcess = 0;
    for (final File file : files) {
        if (!file.isDirectory()) {
            noOfFilesToProcess++;
        }
    }
    final CountDownLatch startSignal = new CountDownLatch(1);
    final CountDownLatch doneSignal = new CountDownLatch(noOfFilesToProcess);
    final PrintWriter outWriter = new PrintWriter(System.out);
    for (final File file : files) {
        if (file.isDirectory())
            continue;
        Thread thread = new Thread() {
            public void run() {
                FileStringifier fd = new FileStringifierProxy(
                        file.getPath(), startSignal, doneSignal);
                fd.display(outWriter);
            }
        };
        thread.start();
    }
    // Do something here
    startSignal.countDown(); // let all threads proceed
    // Do something here while other threads are processing
    try {
        doneSignal.await(); // wait for all to finish
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    // Do something after all thread finishes
}