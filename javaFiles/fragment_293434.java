public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    int previous, current;

    previous = keyboard.nextInt();
    current = keyboard.nextInt();

    while (current != previous) {
        previous = current;
        current = keyboard.nextInt();
    }

    System.out.println("Done!");