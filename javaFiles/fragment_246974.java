public ArrayList<Node> getCSVFile(String file){
    String csvFile = file;
    BufferedReader br = null;
    String line = "";
    String cvsSplitBy = ",";
    ArrayList<Node> nL = new ArrayList<Node>();
    int count = 0;

    try {

        br = new BufferedReader(new FileReader(csvFile));
        while ((line = br.readLine()) != null) {

                // use comma as separator
            String[] node = line.split(cvsSplitBy);
            double pVal;

            try {
                pVal = Double.parseDouble(node[4]);
            } catch (NumberFormatException e) {
                continue;   // Skip this line if this isn't a double
            }

            nL.add(new Node(count, node[0], pVal));

            count++;
        }

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

    return nL;
}