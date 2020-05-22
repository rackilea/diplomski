class Product {

    @JsonProperty("product_id")
    public String productId;
    @JsonProperty("sku")
    public String sku;
    @JsonProperty("display_sku")
    public String displaySku;
    @JsonProperty("genart_number")
    public Integer genartNumber;
    @JsonProperty("name")
    public String name;
    @JsonProperty("description")
    public Object description;
    @JsonProperty("additional_info_text")
    public Object additionalInfoText;
    @JsonProperty("product_url")
    public String productUrl;
    @JsonProperty("image_url")
    public String imageUrl;
    @JsonProperty("brand")
    public String brand;
    @JsonProperty("eans")
    public List<String> eans = null;
    @JsonProperty("manufacturer_product_number")
    public String manufacturerProductNumber;
    @JsonProperty("data_supplier_number")
    public String dataSupplierNumber;
    @JsonProperty("pricehammer")
    public Boolean pricehammer;
    @JsonProperty("buyable")
    public Boolean buyable;
    @JsonProperty("bulky_good")
    public Boolean bulkyGood;
    @JsonProperty("risky_good")
    public Boolean riskyGood;
    @JsonProperty("hazardous_good")
    public Boolean hazardousGood;
    @JsonProperty("car_specific")
    public Boolean carSpecific;
    @JsonProperty("has_deposit")
    public Boolean hasDeposit;
    @JsonProperty("is_exchange_part")
    public Boolean isExchangePart;
    @JsonProperty("visibility_status")
    public String visibilityStatus;
    @JsonProperty("deleted")
    public Boolean deleted;

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", sku='" + sku + '\'' +
                ", displaySku='" + displaySku + '\'' +
                ", genartNumber=" + genartNumber +
                ", name='" + name + '\'' +
                ", description=" + description +
                ", additionalInfoText=" + additionalInfoText +
                ", productUrl='" + productUrl + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", brand='" + brand + '\'' +
                ", eans=" + eans +
                ", manufacturerProductNumber='" + manufacturerProductNumber + '\'' +
                ", dataSupplierNumber='" + dataSupplierNumber + '\'' +
                ", pricehammer=" + pricehammer +
                ", buyable=" + buyable +
                ", bulkyGood=" + bulkyGood +
                ", riskyGood=" + riskyGood +
                ", hazardousGood=" + hazardousGood +
                ", carSpecific=" + carSpecific +
                ", hasDeposit=" + hasDeposit +
                ", isExchangePart=" + isExchangePart +
                ", visibilityStatus='" + visibilityStatus + '\'' +
                ", deleted=" + deleted +
                '}';
    }
}