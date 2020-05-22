public class App {

    static{ System.loadLibrary(Core.NATIVE_LIBRARY_NAME); }

    public static void main( String[] args ){
        System.out.println("OpenCV configuration simple test:");
        Mat m = Mat.eye(3,3, CvType.CV_8UC1);
        System.out.println("OpenCV matrix = " + m.dump());
    }

 }