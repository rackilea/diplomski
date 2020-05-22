@ElementCollection
@CollectionTable(name = "product_reviews", 
       uniqueConstraints = {@UnqiqueConstraint(columnNames={"product_id", "author_id"})})
public List<Review> getReviews() {
    return reviews;
}