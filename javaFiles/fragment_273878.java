public static void main(String[] args) {

    final int Username = 3387;
    final int Password = 5183;
    final int AccountNumber = 22334455;

 int attempts = 0;
  boolean authenitcated = false;
  do { 
  final int EnteredUsername;
    System.out.println("Enter Username");
    EnteredUsername = console.nextInt();
    System.out.println("Username Entered is " + EnteredUsername);

    System.out.printf("%10s\n", " "); //Ignore these lines, they are just to make the console easier for me to read.

    final int EnteredPassword;
    System.out.println("Enter Password");
    EnteredPassword = console.nextInt();
    System.out.println("Password Entered is " + EnteredPassword);

    System.out.printf("%10s\n", " ");

    final int EnteredAccountNumber;
    System.out.println("Enter Account Number");
    EnteredAccountNumber = console.nextInt();
    System.out.println("Account Number Entered is " + EnteredAccountNumber);

    System.out.printf("%10s\n", " ");

    if (Username == EnteredUsername && (Password == EnteredPassword)
            && (AccountNumber == EnteredAccountNumber)) {

        System.out.println("Authentication Complete!");
        authenitcated = true;

    } else {
        System.out.println("Wrong Username, Password or Account Number. Please try again");
        attempts ++;

    }
   }while(attempts < 3 && authenticated == false)

}