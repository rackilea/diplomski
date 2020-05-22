/**
 * Created by KHEMRAJ on 7/13/2017.
 */
public class AvailablePurchase {
    private String sku;
    private String price;
    private boolean isActive;
    public AvailablePurchase(String sku, String price, boolean isActive) {
        this.sku = sku;
        this.price = price;
        this.isActive = isActive;
    }
    public String getSku() {
        return sku;
    }
    public String getPrice() {
        return price;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}