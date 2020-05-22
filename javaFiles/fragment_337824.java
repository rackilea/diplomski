List<String[]> rowList = new ArrayList<String[]>();
try (BufferedReader br = new BufferedReader(new FileReader("pathtocsvfile.csv"))) {
    String line;
    while ((line = br.readLine()) != null) {
        String[] lineItems = line.split(",");
        rowList.add(lineItems);
    }
    br.close();
}
catch(Exception e){
    // Handle any I/O problems
}
String[][] matrix = new String[rowList.size()][];
for (int i = 0; i < rowList.size(); i++) {
    String[] row = rowList.get(i);
    matrix[i] = row;
}