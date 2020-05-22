public class MyVideoServiceTest {

  @Test
  public void delete(){
    // VideoService is just a mock
    VideoService videoServiceMock = Mockito.mock(VideoService.class); 

    // Creating the real MyVideoService
    MyVideoService myVideoService = new MyVideoService(videoServiceMock);

    // Creating a spy proxy
    MyVideoService myVideoServiceSpy = Mockito.spy(myVideoService);

    ObjectThatUsesMyVideoService underTest = new ObjectThatUsesMyVideoService(myVideoServiceSpy);

    underTest .deleteVideo("SomeValue");

    // Verify that myVideoService was invoked
    Mockito.verify(myVideoServiceSpy, Mockito.times(1)).delete("SomeValue");

    // Verify that myVideoService invoked the VideoService
    Mockito.verify(videoServiceMock, Mockito.times(1)).deleteVideo("SomeValue");
  }
}