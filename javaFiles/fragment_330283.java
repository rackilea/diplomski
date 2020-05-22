public static void main(String[] args) {
    // TODO Auto-generated method stub
    whileLoop3();
}

static Scanner input = new Scanner(System.in);

private static void whileLoop3() {
    System.out.printf("%n%nExecuting whileLoop3...%n%n");

    System.out.printf("%nEnter your next number or \"S\" to stop: ");

    System.out.println();

    int count = 0;
    int total = 0;
    int average = 0;
    String strTemp = "";
    int temp;

    // while loop 10 times
    while (!strTemp.equals("S")) {
        // input number from user

        if (strTemp.equals("")) {
        } else {

            temp = Integer.parseInt(strTemp);

            // add to total
            total += temp; // same as total = total + temp
            count++; // same as count = count + 10
        }
        strTemp = input.nextLine();
    }

    System.out.printf("Count is %d%n", count);
    if (count != 0)
        average = total / count;
    System.out.printf("The average of your numbers is %d%n", average);

}