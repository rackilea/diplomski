private void incrementLikeCount(ParseObject commentObject, int position); 
    commentObject.increment("likeCount");
    this.adapter.remove(position);
    this.adapter.add(commentObject);
    this.adapter.notifyDataSetChanged();      
    commentObject.saveInBackground();
}