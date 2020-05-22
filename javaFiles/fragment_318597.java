public static void main(String args[]) {

    int a = 0;
    int b = 0;
    int c = 0;

    Scanner in = new Scanner(System.in);
    System.out.print("Enter a number : ");

    int input = in.nextInt();

    a = input;
    while (a > 0) {

        b = a % 10;
        c = c + b;
        a = a / 10;

    }
    if (input % c == 0) {
        System.out.println("number is harshad");

    } else {
        System.out.println("number is not harshad");
    }

}