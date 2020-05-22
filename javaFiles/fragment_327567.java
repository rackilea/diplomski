private static ArrayList<int[]> randomizer(int arrays, int size, int seed){
    ArrayList<int[]> tests = new ArrayList<>(arrays);
    for (int j = 0; j < arrays; j++) {
        int[] list = new int[size];
        Random r = new Random(seed + j);
        for(int i = 0; i < size; i++) {
            list[i] = r.nextInt(5 * size); // Multiplier for how big the numbers get
        }
        tests.add(j, list);
    }
    return tests;
}

public static void main(String[] args) {
    int tests = 5;
    int size = 4;
    ArrayList<int[]> arrays = randomizer(tests, size, 10);
    for (int i = 0; i < arrays.size(); i++){
        int[] ints = arrays.get(i);
        for (int j = 0; j < ints.length; j++) {
            System.out.print(ints[j] + ",");
        }
        System.out.println();
    }
}