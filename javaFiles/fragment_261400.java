public class ObjectThatUsesMyVideoService {

  private MyVideoService myVideoService;

  ObjectThatUsesMyVideoService(MyVideoService myVideoService) {
    this.myVideoService = myVideoService;
  }

  public void deleteVideo(String param) {
    myVideoService.delete(param);
  }
}