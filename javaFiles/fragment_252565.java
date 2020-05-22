String[][] splitdata = new String[data.size()][2];
int rowNum = 0;
for (String strLine : data) {
    String[] strWord = strLine.split("[\\s]");
    // Store it in an array as you asked for or join them right here
    splitdata[rowNum][0] = strWord[0];
    splitdata[rowNum][1] = strWord[1];
    ++rowNum;
}
for (String[] row: splitdata) {
    System.out.println(row[0] + "." + row[1] + "@mail.com");
}