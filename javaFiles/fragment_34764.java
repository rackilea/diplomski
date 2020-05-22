class Item2 {
    private String productName;
    private String productDesc;
    private double unitPrice;
    private int units;

    public Item2(){
        productName = "";
        productDesc = "";
        unitPrice = -1;
        units = -1;
    } 

    public Item2(String newProductName, 
                String newProductDesc, 
                double newUnitPrice, 
                int newUnits) {
        productName = newProductName;
        productDesc = newProductDesc;
        unitPrice = newUnitPrice;
        units = newUnits;
    }

    public String getProductName(){
        return productName;
    }
    public String getproductDesc(){
        return productDesc;
    }
    public double getUnitPrice(){
        return unitPrice;
    }
    public int getUnits(){
        return units;
    }
    public void setProductName(String newProductName){
        productName = newProductName;
    }
    public void setProductDesc(String newProductDesc){
        productDesc = newProductDesc;
    }
    public void setUnitPrice(double newUnitPrice){
        unitPrice = newUnitPrice;
    }
    public void setUnits(int newUnits){
        units = newUnits;
    }

    public double calculateUnitTotal(){
        return unitPrice * (double) units;
    }

    public String toString() {
       NumberFormat fmt = NumberFormat.getCurrencyInstance();
       StringJoiner sj = new StringJoiner("\t");
       sj.add(productName).add(unitPrice).add(units).add(fmt.format(unitPrice * units));      
       return sj.toString();
    }   
}