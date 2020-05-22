while (true) {
    Scanner scanner = new Scanner(System.in);
    System.out.println("1.Login\t2.Sign Up\t0.Close");
    int choice = 0;
    choice = scanner.nextInt();
    scanner.nextLine();
    User user = new User();
    Tweets tweets = new Tweets(uSname);
    Account accounts = new Account();
    switch (choice) {
    case 1:
        System.out.println("Enter UserName:");
        uSname = scanner.nextLine();
        System.out.println("Enter Your Password:");
        Cpassword = scanner.nextLine();
        accounts.login(uSname, Cpassword);
        Tweets t = new Tweets(uSname);
        accounts.follow();
        //t.display();
        break;
    case 2:
        try {
            signup();
        } catch (Exception e) {
            System.out.println(e);
        }
        break;
    }

}