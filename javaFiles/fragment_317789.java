static long time(Runnable r) {
    long start = System.nanoTime();
    r.run();
    return System.nanoTime() - start;
}

static int cs = 0;

public static void main(String[] args) {
    char[] bigString = new char[100000];
    Arrays.fill(bigString, 0, bigString.length / 4, 'A');
    Arrays.fill(bigString, bigString.length / 4, bigString.length / 2, 'B');
    Arrays.fill(bigString, bigString.length / 2, bigString.length * 3 / 4, 'C');
    Arrays.fill(bigString, bigString.length * 3 / 4, bigString.length, 'D');
    String s = new String(bigString);
    float avgCopy = 0, avgLoop = 0;
    final int times = 100000;
    for(int i = 0; i < times; i++) {
        avgLoop += time(() -> {
            cs = 0;
            for(int j = 0; j < s.length(); j++)
                cs += s.charAt(j) == 'C' ? 1 : 0;
        });
    } avgLoop /= times;
    for(int i = 0; i < times; i++) {
        avgCopy += time(() -> {
            char[] chars = s.toCharArray();
            cs = 0;
            for(char c : chars)
                cs += c == 'C' ? 1 : 0;
        });
    } avgCopy /= times;
    System.out.println("copy: " + avgCopy + " ns");
    System.out.println("loop: " + avgLoop + " ns");
    System.out.println("There were (obviously) " + cs + " Cs in that string.");
}