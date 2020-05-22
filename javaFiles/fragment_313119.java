public String[] getColumnNames(String csvFileDestination){
    BufferedReader br = null;
    String line = "";
    String[] columnNames;

    try {

        br = new BufferedReader(new FileReader(csvFileDestination));
        while ((line = br.readLine()) != null) {

            // use comma as separator
            columnNames = line.split(",");
            break;// Breaking out because you only need the first row

        }
        return columnNames;

    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        if (br != null) {
           try {
               br.close();
            } catch (IOException e) {
               e.printStackTrace();
           }
        }
    }
    return null;
}