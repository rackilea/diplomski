public class Item {

    private String itemName;
    private Integer itemPrice;

    public Item(){}
    public Item(String itemName, int itemPrice){
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public Integer getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(Integer itemPrice) {
        this.itemPrice = itemPrice;
    }
    @Override
    /*
     * This is very important to override as it will be used by JList to show the item name
     */
    public String toString(){
        return this.itemName;
    }
}