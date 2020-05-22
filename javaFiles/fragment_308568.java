// Producer1
public void run() {
    cubbyhole.setContents(this.number);
    Vector vectorList = new Vector();
    System.out.println("Producer <current thread>" + this.currentThread()
            + "put: " + this.number
            + "processing file is" + cubbyhole.getProcessingFile());
    RandomAccessFile raf = null;

    try {
        // ...
    }

// Consumer1
public void run() {
    int value = 0;

    System.out.println("Consumer <current thread>" + this.currentThread()
            + "got: " + cubbyhole.getContents()
            + "processing file is" + cubbyhole.getProcessingFile());
}