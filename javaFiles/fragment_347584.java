static Mat processFace(Net net, Mat img) {
Mat blob = Dnn.blobFromImage(img, 1./255, new Size(96,96), Scalar.all(0), 
true, false);
net.setInput(blob);
return net.forward().clone();
}

  public static void main(String[] args) {
// Load the native library.
System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

Net net  = Dnn.readNetFromTorch("openface.nn4.small2.v1.t7");

Mat img1 = Imgcodecs.imread("../img/face1.png");
Mat img2 = Imgcodecs.imread("../img/face2.jpg");

Mat feature1 = processFace(net, img1);
Mat feature2 = processFace(net, img2);
double distance = Core.norm(feature1, feature2);
System.out.println("distance: " + distance);
}