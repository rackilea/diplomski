public static void main(String[] args){
    Scanner in = new Scanner(System.in);

    System.out.print("Enter your name : ");
    String first_name = in.nextLine();
    System.out.print("Enter your middle name : ");
    String middle_name = in.nextLine();
    System.out.print("Enter your last name : ");
    String last_name = in.nextLine();

    System.out.println("First name : " + first_name);
    if(!middle_name.isEmpty()) {
        System.out.println("Middle name : " + middle_name);
    }
    System.out.println("Last name : " + last_name);

    in.close();
}