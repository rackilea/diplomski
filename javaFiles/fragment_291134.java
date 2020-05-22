class SimpleStockManager{
    // The key of your map will be sku, 
    //and the name and the price can be for exemple in a Product class
    private HashMap<String, Product>  products = new HashMap<>();

    public void newItem(String sku, String name, double price){
        // A call to newItem will create a new Product and store it 
        products.put(sku, new Product(name, price));
    }

    public String getItemName(String sku){
        if (products.containsKey(sku)){
            return products.get(sku).getName();
        }else {
            return " Product not found...";
        }
    }
}