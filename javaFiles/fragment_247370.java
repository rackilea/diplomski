public class MerchandisingGroup {
    private String productCode;
    private String productDescription;

    public String getProductCode() {
        return productCode;
    }
    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
    public String getProductDescription() {
        return productDescription;
    }
    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    @Override
    public String toString() {
        return "MechandisingGroup [productCode=" + productCode + ", productDescription=" + productDescription + "]";
    }
}