public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int arrLen = Integer.parseInt(sc.nextLine());
    int[] array = new int[arrLen];
    String[] strNums = sc.nextLine().split(" ", arrLen);
    for (int i = 0; i < arrLen; i++) {
        array[i] = Integer.parseInt(strNums[i]);
    }

    Arrays.sort(array);

    int numTests = Integer.parseInt(sc.nextLine());
    for (int i = 0; i < numTests; i++) {
        int maxAvg = Integer.parseInt(sc.nextLine());
        int limit = 0;
        int count = 0;
        for (int j : array) {
            int diff = j - maxAvg;
            if (limit + diff < 0) {
                count++;
                limit += diff;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
    sc.close();
}