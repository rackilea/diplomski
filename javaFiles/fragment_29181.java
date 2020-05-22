public static void main(String[] args) {
    int mstop;
    int number;
    int sum;
    int mcounter;
    String numbers = "";

    Scanner input = new Scanner(System.in);

    System.out.print(" Now many numbers am I adding? ");
    mstop = console.nextInt();
    System.out.println();
    sum = 0;
    mcounter = 0;

    System.out.println(" Please provide  " + mstop + " numbers.");
    while (mcounter < mstop) {
        number = console.nextInt();
        sum = sum + number;
        numbers += " " + Integer.toString(number);
        mcounter++;
    }
    System.out.print("The sum of these " + mstop + " numbers:" + numbers
            + " = " + sum);
    System.out.println();
    if (mcounter != 0) {
        System.out.printf("Thank you for your input");
    }
}