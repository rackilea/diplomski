public class Prize {
    private String name;  // <-- not static.
    private int price;  // <-- not static.
    public Prize(String name, int price){
        this.name = name;
        this.price = price;
    }
    public int getPrice() {  // <-- not static.
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public String getName() { // <-- not static.
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }   
}