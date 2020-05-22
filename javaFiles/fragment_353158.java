public static void main(String[] args) {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("Enter minimum range value: ");
    int min = keyboard.nextInt();
    System.out.println("Enter maximum range value: ");
    int max = keyboard.nextInt();
    int sum = 0;

    for(int i = min; i < max; i++) {
        if(i % 2 != 0) {
            sum += i;
        }
    }

    System.out.println("The sum of the odd numbers from " + min + " to " + max + " are " +  sum);
}