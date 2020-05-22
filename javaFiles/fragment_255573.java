public static void main(String args[]) {
   System.loadLibrary( Core.NATIVE_LIBRARY_NAME );
   String file = "AbsolutePathToTheSRCImage2.png";
   Mat src = Imgcodecs.imread(file);
   Mat dst = new Mat();
   Imgproc.cvtColor(src, dst, Imgproc.COLOR_RGB2GRAY);
   Imgcodecs.imwrite("AbsolutePathToTheDSTImage2", dst);
}