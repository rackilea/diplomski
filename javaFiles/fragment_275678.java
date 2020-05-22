Scanner scanner = new Scanner(System.in);
scanner.useDelimiter(System.getProperty("line.separator")); // this scans for lines
while (scanner.hasNext()) {
    String input = scanner.next();
    System.out.println(input); // take a look for yourself
}