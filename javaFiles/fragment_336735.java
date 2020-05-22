Scanner sc = new Scanner(System.in);
System.out.print("Enter a number: ");
int number = sc.nextInt();
sc.nextLine();  // ***** to swallow the dangling EOL token
System.out.print("Enter name: ");
String name = sc.nextLine();