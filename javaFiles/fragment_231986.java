public void readFile() throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;
    ArrayList<String> list = new ArrayList<String>();

    while ((line = br.readLine()) != null) {
        list.add(line);
        System.out.println(line);
    }
    br.close();
}