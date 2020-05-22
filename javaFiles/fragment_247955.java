@ManagedBean
@ViewScope
public class PostBean{

  PostData post;

  @PostContruct
  public void initBean(){
    post = dbManager.getPostData(id);

  }
  public PostData getPost(){
  return post;
  }
  public void setPost(PostData post){
  this.post = post;
  }
}