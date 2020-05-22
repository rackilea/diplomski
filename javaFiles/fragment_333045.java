Scanner scan = new Scanner(System.in);
scan.useDelimiter("\\s*");
System.out.println("Enter commands U(up),D(down),L(left),R(right)");
String command = scan.next();

if (command.equalsIgnoreCase("U")) {
    System.out.println("Do this");
} else if (command.equalsIgnoreCase("D")) {
    System.out.println("Do that");
} else {
    System.out.println("unknown command: "+ command);
}