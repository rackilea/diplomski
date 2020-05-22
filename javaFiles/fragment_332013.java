FileInputStream input = new FileInputStream(file);
while (!Thread.currentThread().isInterrupted()) {
    byte[] bytes = new byte[1024];
    int readN = input.read(bytes);
    if (readN > 0) {
        byte[] sub = ArrayUtils.subarray(bytes, 0, readN);
        System.out.print("Read: " + Arrays.toString(sub) + "\n");
    }
    Thread.sleep(100);
}