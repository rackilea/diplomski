final Ordering<CommentModel> o = new Ordering<CommentModel>() {
    @Override
    public int compare(final CommentModel left, final CommentModel right) {
        return left.getCreationTime().compareTo(right.getCreationTime());
    }
};
return o.max(comments);