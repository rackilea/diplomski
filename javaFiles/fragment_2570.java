class Product {

    @SerializedName("id")
    private int id;

    @SerializedName("price")
    int price;

    @SerializedName("discount")
    int discount;

    @SerializedName("name")
    private String name;

    @SerializedName("image")
    private String image;

    @SerializedName("description")
    private String description;

    @SerializedName("discount_type")
    private String discount_type;

    @SerializedName("discount_exp")
    private String discount_exp;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDiscount_type() {
        return discount_type;
    }

    public void setDiscount_type(String discount_type) {
        this.discount_type = discount_type;
    }

    public String getDiscount_exp() {
        return discount_exp;
    }

    public void setDiscount_exp(String discount_exp) {
        this.discount_exp = discount_exp;
    }
}