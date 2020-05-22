public class UserPurchaseItemsBean {
    private String sku;
    private String purchasedata;
    private String signature;
    public UserPurchaseItemsBean(String sku, String purchasedata, String signature) {
        this.sku = sku;
        this.purchasedata = purchasedata;
        this.signature = signature;
    }
    public String getSku() {
        return sku;
    }
    public String getPurchasedata() {
        return purchasedata;
    }
    public String getSignature() {
        return signature;
    }
}