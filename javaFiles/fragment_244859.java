public static void main(String[] args) {
    new HTDemo().run();
}
public HTDemo() {
    initializeNumberMap();
}
public void run() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Input a number between 1 and 10 inclusively.");
    int number = sc.nextInt();
    if (number >= 1 && number <= 10) {
        System.out.println("You entered " + numbers.get(number);
    } else {
        System.out.println("I don't understand " + number + " yet.");
    }
}