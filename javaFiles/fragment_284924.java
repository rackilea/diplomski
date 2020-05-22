class InventoryItemBuilder {
    @SerializedName("cat1_id")   private int    catOneId;
    @SerializedName("cat1_name") private String catOneName;
    @SerializedName("cat2_id")   private int    catTwoId;
    @SerializedName("cat2_name") private String catTwoName;

    public InventoryItem buildInventoryItem() {
        Category c1 = new Category(catOneId, catOneName);
        Category c2 = new Category(catTwoId, catTwoName);
        return new InventoryItem(c1, c2);
    }
}