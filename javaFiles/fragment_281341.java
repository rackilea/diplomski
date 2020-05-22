DateTime dateTime = new DateTime(post.getUploadDate().get$date()); 
viewHolder.timeago.setText(prettyTime.format(dateTime.toDate()));
viewHolder.likesTextView.setText(String.valueOf(format(post.getLikes())));
viewHolder.footprints.setText(String.valueOf(format(post.getLocation().size)) - 1)));

Post{
    //Your existing property
    @Expose(serialize = false, deserialize = false)
    //equals neither serialize nor deserialize or
    private DateTime uploadedDateTime;
    //etc. prettyTime.format, String.valueOf
}