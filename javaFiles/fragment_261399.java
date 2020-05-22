public class MyVideoService {

  private VideoService videoService;

  public MyVideoService(VideoService videoService) {
    this.videoService = videoService;
  }

  public void delete(String param) {
    videoService.deleteVideo(param);
  }
}

public class VideoService {
  public void deleteVideo(String param) {
  }
}