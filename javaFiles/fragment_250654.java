public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    System.out.println("Enter a name:");
    String name = input.nextLine();
    System.out.println("Enter a name list:");
    String nameList = input.nextLine();
    System.out.println("Enter last name:");
    String lastName = input.nextLine();
    input.close();
    System.out.println(name + " * " + nameList + " ** " + lastName);
}