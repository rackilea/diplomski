int[] data = new int[] {2, 3, 4, 2, 6, 2, 5, 1};
int W = 3;
TreeMap<Integer,Integer> counts = new TreeMap<Integer,Integer>();
for (int i = 0 ; i != W ; i++) {
    if (counts.containsKey(data[i])) {
        counts.put(data[i], counts.get(data[i])+1);
    } else {
        counts.put(data[i], 1);
    }
}
for (int i = W ; i != data.length ; i++) {
    Integer max = counts.lastKey();
    System.out.println(max);
    int tmp = counts.get(data[i-W])-1;
    if (tmp != 0) {
        counts.put(data[i-W], tmp);
    } else {
        counts.remove(data[i-W]);
    }
    if (counts.containsKey(data[i])) {
        counts.put(data[i], counts.get(data[i])+1);
    } else {
        counts.put(data[i], 1);
    }
}
System.out.println(counts.lastKey());