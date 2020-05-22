@Entity(name = "Assignment")
class Assignment {
   @Id
   private int id;

   private String assignmentCode;

   @OneToMany(mappedBy = "assignment")
   private List<Review> reviews = new ArrayList<Review>();

   public void addReview(Review review) {
        reviews.add(review);
        reviews.setPost(this);
    }

    public void removeReview(Review review) {
        reviews.remove(review);
        reviews.setAssignment(null);
    }

}

@Entity(name = "Review")
class Review {
   @Id
   private int id;

   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(
      name = "assignmentCode", 
      referencedColumnName = "assignmentCode"
   )
   private Assignment assignment;
}