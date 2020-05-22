public enum ProductType {
    ABC(ProductType.ABC_BEAN_NAME),
    DEF(ProductType.DEF_BEAN_NAME);

    public static final String ABC_BEAN_NAME = "abcProductHandler";
    public static final String DEF_BEAN_NAME = "defProductHandler";

    private String beanName;

    ProductType(String beanName) { this.beanName = beanName; }

    public String beanName() { return beanName; }
}