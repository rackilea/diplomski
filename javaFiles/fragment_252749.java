CSVReader reader1 = new CSVReader(new FileReader(mydata_csv.getpath()));
List<String[]> myDatas = reader1.readAll();
String[] lineI = myDatas.get(i);
for (String[] line : myDatas) {
    for (String value : line) {
        //do stuff with value
    }
}