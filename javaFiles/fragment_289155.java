public class Ads implements Serializable {
    public void setAdCategoryId(AdCategories category) {
        this.category.removeAd(this);
        this.category = category;
        this.category.addAd(this);
    }
}