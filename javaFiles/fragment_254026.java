public static void main(String[] args) {
    Random r = new Random();

    List<Integer> ints = new ArrayList<>();
    for (int i = 0; i < 10000000; i += 2) {
        int randomNumber = r.nextInt(100) + 10;
        ints.add(randomNumber);
        ints.add(randomNumber);
    }
    ints.add(5); // Lonely Integer
    int tempIndex = r.nextInt(ints.size());
    int tempValue = ints.get(tempIndex);
    // Swap duplicate integer with lonely integer
    ints.set(tempIndex, ints.get(ints.size() - 1));
    ints.set(ints.size() - 1, tempValue);

    Map<Integer, Integer> counts = new HashMap<>();
    for (int i : ints) {
        if (counts.containsKey(i)) {
            counts.put(i, counts.get(i) + 1);
        } else {
            counts.put(i, 1);
        }
    }

    for (Integer key : counts.keySet()) {
        if (counts.get(key) == 1) {
            System.out.println("Single Instance: " + key);
        }
    }
}