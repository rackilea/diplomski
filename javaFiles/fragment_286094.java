public static void main(String[] args) {
    store storeA = new store();
    storeA.name = "Walmart";
    storeA.products = new store.product[3];
    storeA.products[0] = new store.product();
    storeA.products[0].name = "Horses";
    System.out.println(storeA.products[0].name);
}