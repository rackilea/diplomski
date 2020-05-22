public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter film's name");
    String a = scan.nextLine();
    System.out.println("What number did the film released?");
    int b = scan.nextInt();
    scan.nextLine(); // this
    System.out.println("Who's the director?");
    String c = scan.nextLine();
    System.out.println("How long is the film in minutes?");
    int d = scan.nextInt();
    scan.nextLine(); // this
    System.out.println("Have you seen the movie? Yes/No?");
    String e = scan.next();
    System.out.println("Mark for the film?");
    double f = scan.nextDouble();
    scan.nextLine(); // after nextDouble() too
}