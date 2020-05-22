File inFile = new File("shareholders.txt");
    Scanner inputFile = new Scanner(inFile);
    String str;
    int i=0;
    Shareholder[] shareholder = new Shareholder[n];

    while (inputFile.hasNext()) {
        str = inputFile.nextLine();
        String tokens[] = str.split(",");
        shareholder[i++] = new Shareholder(tokens[0],tokens[1],tokens[2],tokens[3]);
    }