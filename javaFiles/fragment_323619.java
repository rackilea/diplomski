package test;

public class Cart {
    private String id;
    private Checkout checkoutID;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Checkout getCheckoutID() {
        return checkoutID;
    }

    public void setCheckoutID(Checkout checkoutID) {
        this.checkoutID = checkoutID;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", checkoutID=" + checkoutID +
                '}';
    }
}

package test;

public class Checkout {
    private String id;
    private String billingAddress;
    private String shippingAddress;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBillingAddress() {
        return billingAddress;
    }

    public void setBillingAddress(String billingAddress) {
        this.billingAddress = billingAddress;
    }

    public String getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(String shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @Override
    public String toString() {
        return "Checkout{" +
                "id='" + id + '\'' +
                ", billingAddress='" + billingAddress + '\'' +
                ", shippingAddress='" + shippingAddress + '\'' +
                '}';
    }
}

package test;

public class CartResponse {
    private String result;

    public CartResponse(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}