try {
  File file = new File("symbolTable.txt");
  Scanner scanner=new Scanner(file);
  while (scanner.hasNextLine()) {
    // toLowerCase will do nothing for characters that are not letters
    // Don't spend CPU cycles with regex
    String symbolLine=scanner.nextLine().toLowerCase();
    // Collect the symbol only if non-empty?? This will save you from empty symbols
    if(symbolLine.trim().length()>0) {
      symbolTable.add(symbolLine); // or .add(symbolLine.trim()) ???
    }
  }
  scanner.close();
} catch (Exception ex) {
  ex.printStackTrace();
}