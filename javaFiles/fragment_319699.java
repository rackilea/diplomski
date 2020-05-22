public static void main(String[] args) {
    long startTime = System.currentTimeMillis();

    // Do other stuff...

    long stopTime = System.currentTimeMillis();
    int elapsedSeconds = (int)((stopTime - startTime) / 1000);
    System.out.println(elapsedSeconds + " seconds elapsed");
}