public static void main(String[] args) {
    Scanner reader = new Scanner(System.in);
    System.out.print("What is your first name? ");
    String firstName = reader.nextLine();
    System.out.print("What is your last name? ");
    String lastName = reader.nextLine();
    System.out.print("What is your mothers maiden name? ");
    String maidenName = reader.nextLine();
    System.out.print("What town were you born? ");
    String town = reader.nextLine();

    System.out.print("Your Star Wars name is: " + //
            buildStarWarsName(firstName, lastName, maidenName, town));
}