try {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter file name");
    String fileName = scan.nextLine();
    Scanner inFile = new Scanner (Paths.get(fileName));
    while (inFile.hasNextLine()) {
        String dataLine = inFile.nextLine();
        if (dataLine.length()>6){
            Scanner line = new Scanner (dataLine);
            String month = line.next();