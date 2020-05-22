void testNumber(int c[], int d[]) {
    System.out.println(Arrays.toString(c));
    System.out.println(Arrays.toString(d));

    Set<Integer> hset = new LinkedHashSet<>();

    for (int i = 0; i < c.length; i++) {
        for (int j = 0; j < d.length; j++) {
            if (c[i] == d[j]) {
                hset.add(c[i]);
            }
        }
    }
    System.out.println(hset);
}