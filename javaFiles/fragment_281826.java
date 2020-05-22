public class CommentModel {
    private String comment, commentDate, profilePic, commentUser;

    public CommentModel() {}

    public CommentModel(String comment, String commentDate, String profilePic, String commentUser) {
        this.comment = comment;
        this.commentDate = commentDate;
        this.profilePic = profilePic;
        this.commentUser = commentUser;
    }

    public String getComment() { return comment; }
    public String getCommentDate() { return commentDate; }
    public String getProfilePic() { return profilePic; }
    public String getCommentUser() { return commentUser; }
}