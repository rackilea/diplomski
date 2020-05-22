public static void Main(String[] args) {
    Scanner scan = new Scanner(System.in);
    do {
        System.out.println("Enter desired number:");
        String in = scan.nextLine();
        rollDice(Integer.parseInt(in));
        // Implement console output formatting here
    } while(!in.equalsIgnoreCase("q"))
}