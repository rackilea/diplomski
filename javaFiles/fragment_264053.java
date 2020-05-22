public class ItemInfo {
    private String name;
    private String rfdNumber;
    private double price;
    private String originalPosition;

    public ItemInfo(){
    }

    public ItemInfo(String name, String rfdNumber, double price, String originalPosition) {
        this.name = name;
        this.rfdNumber = rfdNumber;
        this.price = price;
        this.originalPosition = originalPosition;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRfdNumber() {
        return rfdNumber;
    }

    public void setRfdNumber(String rfdNumber) {
        this.rfdNumber = rfdNumber;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getOriginalPosition() {
        return originalPosition;
    }

    public void setOriginalPosition(String originalPosition) {
        this.originalPosition = originalPosition;
    }
}