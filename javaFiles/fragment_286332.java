private static int size = 100000;

public static void main(String[] args) {
    int[] array1 = new int[size];
    int[] array2 = new int[size];

    for (int i = 0; i < size; i++) {
        array1[i] = i;
        array2[i] = i + i;
    }

    System.out.println("starting set");
    startTimer();
    compareAgainstSet(array1, array2);
    long set = stopTimer();
    System.out.println("against set: " + set + "ms\n");

    System.out.println("starting map");
    startTimer();
    compareAgainstMap(array1, array2);
    long map = stopTimer();
    System.out.println("against hashmap: " + map + "ms\n");

    System.out.println("starting loops with break");
    startTimer();
    twoLoopsWithBreak(array1, array2);
    long loopsBreak = stopTimer();
    System.out.println("2 loops with break: " + loopsBreak + "ms\n");

    System.out.println("starting loops without break");
    startTimer();
    twoLoopsWithoutBreak(array1, array2);
    long loops = stopTimer();
    System.out.println("2 loops without break: " + loops + "ms\n");

}

private static void twoLoopsWithoutBreak(int[] arr1, int[] arr2) {
    ArrayList<Integer> doubles = new ArrayList<>();
    for (int i : arr1) {
        for (int j : arr2) {
            if (i == j) {
                doubles.add(i);
            }
        }
    }
}

private static void twoLoopsWithBreak(int[] arr1, int[] arr2) {
    ArrayList<Integer> doubles = new ArrayList<>();
    for (int i : arr1) {
        for (int j : arr2) {
            if (i == j) {
                doubles.add(i);
                break;
            }
        }
    }
}

private static void compareAgainstSet(int[] arr1, int[] arr2) {
    ArrayList<Integer> doubles = new ArrayList<>();
    Set<Integer> set1 = new HashSet<Integer>();
    for (int i : arr1) {
        set1.add(i);
    }
    for (int i : arr2) {
        if (set1.contains(i)) {
            doubles.add(i);
        }
    }
}

private static void compareAgainstMap(int[] arr1, int[] arr2) {
    ArrayList<Integer> doubles = new ArrayList<>();
    HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
    for (int i : arr1) {
        hashmap.put(i, 0);
    }
    for (int i : arr2) {
        if (hashmap.containsKey(i)) {
            doubles.add(i);
        }
    }
}

private static long startTime;

private static void startTimer() {
    startTime = System.currentTimeMillis();
}

private static long stopTimer() {
    return System.currentTimeMillis() - startTime;
}