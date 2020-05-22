System.out.println("Please enter the inital values. Press enter when done.");
final String line = scan.nextLine();
final Scanner lineScanner = new Scanner(line);
while(lineScanner.hasNextInt()) {
    oak.add(lineScanner.nextInt());
}