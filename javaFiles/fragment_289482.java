public List<Product> readSnacks() throws FileNotFoundException, IOException {
    List<Product> listsnack = new ArrayList<>();
    BufferedReader in = new BufferedReader(new FileReader("input.txt"));
    String line;
    while ((line = in.readLine()) != null) {
        snackline = linea.split("\t");
        String code =snackline[0];
        String name = snackline[1];
        String price = snackline[2];
        Product p1 = new Product(snackline[0], snackline[1], snackline[2]);
        listsnack.add(p1);
    }
    return listsnack;
}