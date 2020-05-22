public void readFile() throws FileNotFoundException, IOException {
    BufferedReader br = new BufferedReader(new FileReader(file));

    String line;

    while ((line = br.readLine()) != null) {
        cyclistList = (List) Arrays.asList(line);
        System.out.println(line);
    }
    br.close();
}