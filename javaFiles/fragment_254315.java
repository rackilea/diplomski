Scanner input = new Scanner(System.in);
PrintWriter out = new PrintWriter("contactRequest.txt");

String email;
String prompt = "Please enter your name: ";
do {
    System.out.print(prompt);
    email = input.nextLine();
    prompt = "\nPlease enter a valid E-Mail.\n"
} while (!email.matches("[a-zA-Z]+"));

out.println("E-Mail: " + email);