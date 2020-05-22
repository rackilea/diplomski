public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    String number[] = new String[100];
    int sum = 0;
    int noOfInputs = 2;
    int value[] = new int[noOfInputs];
    for (int x = 0; x <= noOfInputs-1; x++) {
        System.out.print("input number : ");
        number[x] = in.next();
        value[x] = Integer.parseInt(number[x]);
        sum = sum + value[x];
    }
    for (int x = 0; x <= noOfInputs-1; x++) {
        System.out.println("Data Number " + (x + 1) + " : " + number[x]);
    }
    System.out.println("Sum :\t " + sum);

}