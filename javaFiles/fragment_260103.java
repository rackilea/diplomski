public static void main(String[] args) throws InputValidationException {

    Scanner input = new Scanner(System.in);
    List<salesPerson> sPerson = new ArrayList<salesPerson>();

    // Loop forever
    // Need a way to break the loop. One option: have the user
    // input "q" for quit
    while (true) {

        //ask user for input and get input
        System.out.println("Enter id ('q' to quit): ");
        String temp = input.nextLine();
        if (temp.equals("q")) break;

        int id = Integer.parseInt(temp);
           // This should be in try/catch in case parseInt fails

        System.out.println("Enter first name:");
        String firstName = input.nextLine();

        System.out.println("Enter last name:");
        String lastName = input.nextLine();

        //save in array list
        sPerson.add(new salesPerson(id, firstName, lastName));
    }

    // Print the list
    sPerson.forEach(System.out::println);
}