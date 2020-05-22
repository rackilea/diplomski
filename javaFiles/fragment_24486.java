public static void main(String[] args) throws IOException {
    String dataRow;
    BufferedReader CSVFile = new BufferedReader(new InputStreamReader(new FileInputStream("F:\\csv.csv"),"unicode"));
    while ((dataRow = CSVFile.readLine()) != null) {
        String []data = dataRow.split(";");
        for (String d : data) {
            System.out.print(d + " ");
        }
        System.out.println();
    }
    CSVFile.close();
    System.out.println("Done");
}