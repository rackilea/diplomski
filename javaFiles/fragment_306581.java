private static void findSum(int[] aArr, int[] bArr, int x) {
    Set<Integer> bSet = new HashSet<>();
    for (int b : bArr)
        bSet.add(b);
    for (int a : aArr)
        if (bSet.contains(x - a))
            System.out.println(a + " + " + (x - a) + " = " + x);
}