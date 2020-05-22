public static void main(String[] args) {
    final int[] myArray = new int[10];

    System.out.println("MainThread creating first WorkerThread and awaiting termination of last WorkerThread");
    Thread t = new Thread(new ArrayWorker(myArray, 0));
    try {
        t.start();
        t.join();
    } catch (InterruptedException ex) {
        ex.printStackTrace();
        System.exit(-1);
    }

    System.out.println("Last WorkerThread finished");
    for (int i : myArray) {
        System.out.print(i + " ");
    }
    System.out.println();
}