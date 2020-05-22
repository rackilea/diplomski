/*******************************************************************************
  EXAMPLE OBJECT V1
*******************************************************************************/
class ReviewComment
{
  private final String username;
  private final String comment;

  ReviewComment(ReviewCommentMessage msg)
  {
    // Throws exception if fields are not present.
    requires(msg.hasUsername());
    requires(msg.hasComment());

    this.username = msg.getUsername();
    this.comment = msg.getComment();
  }

  String getUsername() { return this.username; }

  String getComment()  { return this.comment; }
}

/*******************************************************************************
  EXAMPLE PROCESSOR V1
*******************************************************************************/
public void processReviewComment(ReviewComment review)
{
  // Simulate posting the review to the blog.
  BlogPost.log(review.getUsername(), review.getComment());
}


/*******************************************************************************
  EXAMPLE OBJECT V2
*******************************************************************************/
class ReviewComment
{
  private final String username;
  private final String comment;
  private final Boolean isLiked;

  ReviewComment(ReviewCommentMessage msg)
  {
    // Throws exception if fields are not present.
    requires(msg.hasUsername());
    requires(msg.hasComment());

    this.username = msg.getUsername();
    this.comment = msg.getComment();

    if (msg.hasIsLiked())
    {
      this.isLiked = msg.getIsLiked();
    }
  }

  String getUsername() { return this.username; }

  String getComment()  { return this.comment; }

  // Use Java's built in "Optional" class to indicate that this field is optional.
  Optional<Boolean> isLiked() { return Optional.of(this.isLiked); }
}

/*******************************************************************************
  EXAMPLE PROCESSOR V2
*******************************************************************************/
public void processReviewComment(ReviewComment review)
{
  // Simulate posting the review to the blog.
  BlogPost.log(review.getUsername(), review.getComment());

  Optional<Boolean> isLiked = review.isLiked();

  if (isLiked.isPresent() && !isLiked.get())
  {
    // If the field is present AND is false, send an email telling us someone
    // did not like the product.
    Stats.sendEmailBadReview(review.getComment());  
  }
}


/*******************************************************************************
  EXAMPLE OBJECT V3
*******************************************************************************/
class ReviewComment
{
  private final String username;
  private final String comment;
  private final String location;

  ReviewComment(ReviewCommentMessage msg)
  {
    // Throws exception if fields are not present.
    requires(msg.hasUsername());
    requires(msg.hasComment());
    requires(msg.hasLocation());

    this.username = msg.getUsername();
    this.comment = msg.getComment();
    this.location = msg.getLocation();
  }

  String getUsername() { return this.username; }

  String getComment()  { return this.comment; }

  String getLocation()  { return this.location; }
}

/*******************************************************************************
  EXAMPLE PROCESSOR V3
*******************************************************************************/
public void processReviewComment(ReviewComment review)
{
  // Simulate posting the review to the blog.
  BlogPost.log(review.getUsername(), review.getComment());

  // Simulate converting the location into geo coordinates.
  GeoLocation geoLocation = GeoLocation.from(review.getLocation());

  // Simulate posting the location to the blog.
  BlogPost.log(review.getUsername(), geoLocation);
}