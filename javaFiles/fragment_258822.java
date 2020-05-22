class ResultSet {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public List<ProductBean> getProductBeans() {
        return productBeans;
    }

    public void setProductBeans(List<ProductBean> productBeans) {
        this.productBeans = productBeans;
    }

    private String name;
    private BigDecimal amount;
    private List<ProductBean> productBeans;

    @Override
    public String toString() {
        return "ResultSet{" +
                "name='" + name + '\'' +
                ", amount=" + amount +
                ", productBeans=" + productBeans +
                '}';
    }
}