public static void main(String[] args) {
    int sum = 0;
    System.out.println("Enter numbers here");
    Scanner kb = new Scanner((new Scanner(System.in)).nextLine()); //has to do this to make the kb.hasNexInt() work.
    while (kb.hasNextInt()) {
        sum += kb.nextInt();
    }
    System.out.println(sum);
}