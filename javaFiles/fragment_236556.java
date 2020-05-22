@Test
  public void testLogStderr() throws Exception {
    NativeLibrary.logStdErr();
    System.err.println("testing stderr via slf4j");
    NativeLibrary.load();
    VideoCapture capture = new VideoCapture();
    // Dorf Appenzell
    //String url="http://213.193.89.202/axis-cgi/mjpg/video.cgi";
    // Logitech Cam on test car
    // url="http://picarford:8080/?action=stream";
    File imgRoot = new File(testPath);
    File testStream=new File(imgRoot,"logitech_test_stream.mjpg");
    assertTrue(testStream.canRead());
    capture.open(testStream.getPath());
    Mat image=new Mat();
    capture.read(image);
    assertEquals(640,image.width());
    assertEquals(480,image.height());
    capture.release();
  }