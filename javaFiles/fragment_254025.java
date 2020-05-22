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

    for (int i = 0; i < ints.size(); i++) {
        boolean singleInteger = true;
        for (int j = 0; j < ints.size(); j++) {
            if (j == i) {
                continue;
            }
            if (ints.get(j) == ints.get(i)) {
                singleInteger = false;
                break;
            }
        }

        if (singleInteger) {
            System.out.println("Single instance: " + ints.get(i));
            break;
        }
    }
}