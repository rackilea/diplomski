public static void main(String[] args) {
    printArray1(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 }, 3, 6);
            // prints: '3    4   5   6   '
}

static public void printArray1(int[] intList, int from, int to) {
    if (to > from && intList.length > to) {
        for (int i = from - 1; i < to; i++) {
            System.out.print(intList[i] + "\t ");
        }
    } else {
        System.out.println("Invalid Inputs");
    }
}