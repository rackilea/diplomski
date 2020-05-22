class GameInfo {
    private int numReviews = 0;

    public void addReview(Review r) {
        this.reviews[numReviews++] = r;
    }

    // ...
}