public abstract class CommentEntity {
    private final IntegerProperty commentsCount = new SimpleIntegerProperty();

    public final int getCommentsCount() {
        return commentsCountProperty().get();
    }

    public final void setCommentsCount(int commentsCount) {
        commentsCountProperty().set(commentsCount);
    }

    public IntegerProperty commensCountProperty() {
        return commentsCount ;
    }

    public abstract String getCommentIdentifier();
}