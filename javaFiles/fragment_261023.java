public static void main(String[] args) {
    List<Inventory> invItem = new ArrayList<>();
    BufferedReader br = new BufferedReader(new FileReader("inventory.txt"));

    String fileRead;

    while ((fileRead = br.readLine()) != null) {
        invItem.add(new Inventory(fileRead.split(",")));
    }

    br.close();

    double totalStock = 0;
    for (Inventory inv : invItem) {
        totalStock += inv.getStock();
    }
    System.out.println(totalStock); // prints the total stock
}