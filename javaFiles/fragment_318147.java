File inFile = new File("shareholders.txt");
Scanner inputFile = new Scanner(inFile);
String str;
List<Shareholder> list = new ArrayList<>();

while (inputFile.hasNext()) {
    Shareholder shareholder = new Shareholder();
    str = inputFile.nextLine();
    String tokens[] = str.split(",");
    list.add(new Shareholder(tokens[0],tokens[1],tokens[2],tokens[3]));
}