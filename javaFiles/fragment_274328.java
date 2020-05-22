Scanner sysIn = new Scanner(System.in);
while(sysIn.hasNextLine()) {
    String nextLine = sysIn.nextLine();
    if(nextLine.isEmpty()) {
        break;
    }

    Scanner lineIn = new Scanner(nextLine);
    lineIn.useDelimiter(";|\\,");

    while(lineIn.hasNextInt()) {
        int nextInt = lineIn.nextInt();
        ...
    }
}