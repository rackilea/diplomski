long runTimeNS = 2 * 1000 * 1000 * 1000L;
for (int i = 0; i < 3; i++) {
    long start = System.nanoTime();
    long r;
    for (r = 1; r < runTimeNS; r++) {
        Arrays.sort(list7.clone());
        if (System.nanoTime() - start > runTimeNS) break;
    }
    long time = System.nanoTime() - start;
    System.out.println("Average Arrays.sort() time " + time / r / 1000 + " us.");

    long start1 = System.nanoTime();
    for (r = 1; r < runTimeNS; r++) {
        List<Integer> list = new ArrayList<Integer>();
        for (int j : list7) list.add(j);
        Collections.shuffle(list);
        Collections.sort(list);
        int[] ints = new int[list.size()];
        for (int j = 0; j < list.size(); j++) ints[j] = list.get(j);
        if (System.nanoTime() - start1 > runTimeNS) break;
    }

    long time1 = System.nanoTime() - start1;
    System.out.println("Average shuffle/sort time " + time1 / r / 1000 + " us.");

    long start2 = System.nanoTime();
    for (r = 1; r < runTimeNS; r++) {
        qrsort(list7.clone());
        if (System.nanoTime() - start2 > runTimeNS) break;
    }

    long time2 = System.nanoTime() - start2;
    System.out.println("Average qrsort() time " + time2 / r / 1000 + " us.");
}