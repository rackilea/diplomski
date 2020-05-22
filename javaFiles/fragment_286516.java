public static void main(String[]args) {

Scanner keyboard = new Scanner(System.in);
    double totalPrice = 0.0;
    double input = keyboard.nextDouble();

    while(input >= 0) {
    totalPrice += input;
    input = keyboard.nextDouble();
    }
}