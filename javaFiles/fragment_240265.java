private final static int WARMUP = 1000;
private final static int TEST = 1000;
private final static int SIZE = 500000;

public void perfTest() {
    // Warmup
    for (int i = 0; i < WARMUP; ++i) {
        buildArrayList();
    }
    // Test
    long sum = 0;
    for (int i = 0; i < TEST; ++i) {
        sum += buildArrayList();
    }
    System.out.println("Average time to build array list: " + (sum / TEST));
}

public long buildArrayList() {
    long start = System.nanoTime();
    ArrayList a = new ArrayList();
    for (int i = 0; i < SIZE; ++i) {
        a.add(i);
    }
    long end = System.nanoTime();
    return end - start;
}

... same for buildLinkedList