final int threadCount = 7;
final int[] a = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

int from = 0;
for (int i = 0; i < threadCount; i++) {
    final int to = (from + (int) Math.ceil((a.length - from) / (double) (threadCount - i)));
    System.out.println("Thread #" + i + " will use " + Arrays.toString(Arrays.copyOfRange(a, from, to)));

    from = to;
}