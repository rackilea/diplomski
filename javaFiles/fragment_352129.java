@OneToMany(mappedBy = "course", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
private List<Review> reviews = new ArrayList<>();

public void addReview(Review review){
    review.setCourse(this);
    reviews.add(review);
}