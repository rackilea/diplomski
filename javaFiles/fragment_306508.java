private void incrementLikeCount(ParseObject commentObject, int position); 
    commentObject.increment("likeCount");
    mComments.get(position).increment("likeCount");
    this.adapter.notifyDataSetChanged();      
    commentObject.saveInBackground();
}