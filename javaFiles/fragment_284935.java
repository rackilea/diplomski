public static void main(String[] args) {
    Scanner input = new Scanner(System.in);

    Set<Integer> intSet = new LinkedHashSet<>();
    int[] intArray = new int[5]; //max of 5 values

    for (int i = 0; i < 5; i++) {
        System.out.println("Please enter your desired number that is between 10 and 100: ");
        intSet.add(input.nextInt());
    }

    int[] intArray = new int[intSet.size()];

    int i = 0;
    for (Integer val : intSet) {
        intArray[i++] = val;
    }
}