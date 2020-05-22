public static void main(String[] args) {
    System.out.println("Enter numbers here");
    int sum;
    do {
        Scanner kb = new Scanner(System.in);
        int score = 0;
        sum = 0;
        String line = kb.nextLine();
        kb = new Scanner(line); //has to do this to make the kb.hasNexInt() work.
        while (kb.hasNextInt()) {
            score = kb.nextInt();
            sum += score;
        }
        System.out.println("Sum = " + sum);
    } while (sum != 0);
}