@PATH("/yourPath/")
public class YourClassNameHere{

@POST                                    
public void nameFilePost(@QueryParam("name") String name, @QueryParam("file") File file) {
  userPost(name);
  filePost(file)
  }
}