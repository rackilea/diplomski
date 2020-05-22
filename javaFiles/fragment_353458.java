enum BillCategory {
    VEGAN("VEGAN", PurchaseType.GroceryPurchase), VEGETARIAN("VEGETARIAN",
            PurchaseType.GroceryPurchase), SMARTPHONE("SMARTPHONE", PurchaseType.ElectronicPurchase);

    private String category;
    private PurchaseType type;

    BillCategory(String category, PurchaseType type) {
        this.category = category;
        this.type = type;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public PurchaseType getType() {
        return type;
    }

    public void setType(PurchaseType type) {
        this.type = type;
    }

}

enum PurchaseType {
    ElectronicPurchase, GroceryPurchase;
}