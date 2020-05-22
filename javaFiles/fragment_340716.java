public static void getinput() throws IOException {

    Scanner scanner = new Scanner(System.in);
    String input = null;
    /* End Initialization */

    System.out.println("Welcome ");
    System.out.println("What would you like to know?");

    for (;;) {
        System.out.print("> ");
        input = scanner.nextLine().toLowerCase();
        parseFile(input);

        if (input.equals("bye"))
            break;

        System.out.println("is there anything you want to know?");
        input = scanner.nextLine().toLowerCase();
        parseFile(input);
//might add another checker here
//if (input.equals("bye"))
        //  break;

    }
    System.out.println("have a good day");

}