private TreeMap<String, Double> prices = new TreeMap<String, Double>();

public void readFromFile(String fileName) throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader(new FileReader(fileName));
    StringTokenizer st;
    String line;
    while ((line = br.readLine()) != null) {
        st = new StringTokenizer(line.trim(), " ");
        prices.put(st.nextToken(), Double.parseDouble(st.nextToken()));
    }
    br.close();
}