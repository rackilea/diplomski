public static void main(String[]args) {

Scanner keyboard = new Scanner(System.in);
    double input = 0.0;
    double totalPrice = 0.0;

    do {
        totalPrice += input;
        input = keyboard.nextDouble();
    }

    while(input >= 0);
}