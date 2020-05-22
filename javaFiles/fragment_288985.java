public static void main(String[] args) {
    int[] randomNumbers = randomNums();
    System.out.println(Arrays.toString(randomNumbers));
    System.out.println(Arrays.toString(sortedNums(randomNumbers)));
}

public static int[] randomNums() {
    int[] random = new int[30];
    for (int i = 0; i < random.length; i++) {
        random[i] = (int) (Math.random() * 16);
    }
    return random;
}

public static int[] sortedNums(int[] sort) {
    int[] numVals = new int[16];
    for (int j = 0; j < sort.length; j++) {
        numVals[sort[j]]++;
    }
    return numVals;
}