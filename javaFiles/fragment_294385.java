Scanner scanner = new Scanner(System.in); // System.in is the console's inputstream
System.out.print("Enter text : ");
String input = scanner.nextLine();
// ^^ This reads the entire line. Use this if you expect spaces in your input
// Otherwise, you can use scanner.next() if you only want to read the next token
System.out.println(input);