try {
    //last parameter tells it which line (row) to consider as the first one
    CSVReader reader = new CSVReader(new FileReader("res/test.csv"), '|', '\0', 1);
    String[] row;

    List<String> columnThree    = new ArrayList<String>();
    List<String> columnFour     = new ArrayList<String>();

    while((row = reader.readNext()) != null) {
        columnThree.add(row[2]);
        columnFour.add(row[3]);
    }
    reader.close();
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}