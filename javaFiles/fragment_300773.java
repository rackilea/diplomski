class Paraggelia {

    private Date orderDate;
    private String tableNumber;
    private int customerCount;
    private Map<Product, Integer> listOfItems;

    /*Constructor(s)*/

    Paraggelia(Date orderDate,String tableNumber){
        this.orderDate=orderDate;
        this.tableNumber=tableNumber;
        this.listOfItems = new HashMap<Product, Integer>();
    }


    /*Add && Delete Products from the Order class*/

    public void add(Product p, int quantity){
        if(p == null)
        {
            throw new IllegalArgumentException();
        }else{
            listOfItems.put(p, quantity);
        }
    }

    public void delete(Product p){
        if(p == null)
        {
            throw new IllegalArgumentException();
        }
        else
        {
            listOfItems.remove(p);
        }
    }

    /** Calculates and returns the total price
     * Usually called directly as a parameter of getReceipt function
     * */
    public static float getTotalPrice(){

        return 0;
    }

    /** Creates and returns the final Receipt!
     * -Display must consist of:
     * Item$ - BarCode# - Item Amount#
     * Total Price#
     * Table Number#
     */
    public  String getReceipt(float totalPrice){
        StringBuilder receipt = new StringBuilder();

        for(Map.Entry<Product,Integer> entry : this.listOfItems.entrySet()) {
            Product product = entry.getKey();
            Integer quantity = entry.getValue();

            receipt.append(product.getName() + " " + quantity);
            receipt.append("\n");
        }

        return new String(receipt);
    }


    /*Getters && Setters */
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public String getTableNumber() {
        return tableNumber;
    }
    public void setTableNumber(String tableNumber) {
        this.tableNumber = tableNumber;
    }
    public int getCustomerCount() {
        return customerCount;
    }
    public void setCustomerCount(int customerCount) {
        this.customerCount = customerCount;
    }

}