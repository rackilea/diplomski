String csvFile = "C:\\test.csv";
CSVReader reader;
String[] nextRow;
char cvsSplitBy = ';';

try {

    //Last argument will determine how many lines to skip. 1 means skip header
    reader = new CSVReader(new FileReader(csvFile), cvsSplitBy, CSVParser.DEFAULT_QUOTE_CHARACTER, 1);

    while ((nextRow = reader.readNext()) != null) {

        if(nextRow.length > 2){
            //nextRow[1] will always give second column value
            int tmp = Integer.parseInt(nextRow[1]);
            for (int i = 0; i < tmp; i++) {
                // TO DO
            }
        }
    }
} catch (FileNotFoundException e) {
    e.printStackTrace();
} catch (IOException e) {
    e.printStackTrace();
}