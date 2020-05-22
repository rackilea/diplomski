public class Recommendation {
    //...
    private List<RecommendationImage> images = new ArrayList<>();

    public void addRecommendationImage(final RecommendationImage newImage) {
         recommendationImages.add(newImage);
         newImage.setRecommendation(this);
    }
}