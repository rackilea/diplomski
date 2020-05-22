class GameInfo {
    private List<Review> reviews = new ArrayList<>();

    public void addReview(Review r) {
        reviews.add(r);
    }

    public int getNumberOfReviews() {
        return reviews.size();
    }
}