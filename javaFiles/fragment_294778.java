Recent rec = (Recent) listData.get(position);
List<Post> posts = rec.getPosts();

for(int i = 0; i < posts.size(); i++){

  Post post = (Post) posts.get(i);
  if(post != null){
    List<Attachment> atts = post.getAttachments();
    Attachment att = (Attachment) atts.get(0) // You can use loop instead of get(0)
    List<Images> imgs = att.getImages();
    Images img = (Images) imgs.get(0); // You can use loop instead of get(0)
    Thumbnail thumb = (Thumbnail) img.getThumbnail();
    Author author = (Author) post.getAuthor();    
    ...
  }
}