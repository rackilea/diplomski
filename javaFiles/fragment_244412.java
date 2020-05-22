Scanner scan = new Scanner(System.in);
    AuthenticationProvider authProvider = new AuthenticationProvider();
    authProvider.addAuthentication("D3", "R4");

    System.out.print("The co-ordinates that your after: ");
    String userInput = scan.nextLine();
    System.out.print(authProvider.authenticate(userInput));