public View getItemView(ParseObject comment, View view, ViewGroup parent) {
    view = View.inflate(getApplicationContext(), R.layout.comments_listview_item, null);
    mListViewReferences(view);
    //loadComments();

    commenttext.setText(comment.getString("Comment"));
    commentersUserName.setText(comment.getString("Commenter"));

    return view;
}