public class CommentModel {
    private String comment, commentDate, profilePic, commentUser;

    public CommentModel() {}

    public CommentModel(String comment, String commentDate, String profilePic, String commentUser) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.profilePic = profilePic;
        this.commentUser = commentUser;
    }

    @PropertyName("Comment")
    public String getComment() { return comment; }
    @PropertyName("CommentDate")
    public String getCommentDate() { return commentDate; }
    @PropertyName("ProfilePic")
    public String getProfilePic() { return profilePic; }
    @PropertyName("CommentUser")
    public String getCommentUser() { return commentUser; }
}