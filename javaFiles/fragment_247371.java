public class Product {
    private String subgroupCode;
    private List<ProductGroup> productGroup;

    public String getSubgroupCode() {
        return subgroupCode;
    }
    public void setSubgroupCode(String subgroupCode) {
        this.subgroupCode = subgroupCode;
    }
    public List<ProductGroup> getProductGroup() {
        return productGroup;
    }
    public void setProductGroup(List<ProductGroup> productGroup) {
        this.productGroup = productGroup;
    }

    @Override
    public String toString() {
        return "Product [subgroupCode=" + subgroupCode + ", productGroup=" + productGroup + "]";
    }
}