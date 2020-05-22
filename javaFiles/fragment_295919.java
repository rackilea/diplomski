public static TreeMap<Integer, Integer> tm = new TreeMap<>();

public static void main(String[] args) throws Exception {
    tm.put(80, 0);
    tm.put(76, 1);
    tm.put(64, 3);
    tm.put(56, 4);
    tm.put(48, 10);

    System.out.println(myGet(80));  // 0
    System.out.println(myGet(75));  // 1
    System.out.println(myGet(70));  // 1
}

public static int myGet(int key) {
    Integer value = tm.get(key);

    if (value == null) {
        Entry<Integer, Integer> floor = tm.floorEntry(key);
        Entry<Integer, Integer> ceiling = tm.ceilingEntry(key);

        if ((key - floor.getKey()) < (ceiling.getKey() - key)) {
            value = floor.getValue();
        } else {
            value = ceiling.getValue();
        }
    }

    return value;
}