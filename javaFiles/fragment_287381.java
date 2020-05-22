@BeforeClass
public void setUp(){
    System.loadLibrary("lib/x64/opencv_java300");
}

@Test
public void openCVTest(){
    System.out.println("OpenCV configuration simple test:");
    Mat m = Mat.eye(3,3, CvType.CV_8UC1);
    System.out.println("OpenCV matrix = " + m.dump());
}