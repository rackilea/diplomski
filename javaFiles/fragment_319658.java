MatOfPoint2f approx = new MatOfPoint2f();
Imgproc.approxPolyDP(yourImage, approx, Imgproc.arcLength(yourImage, true) * 0.02, true);
long count = approx.total();
if (count == 5) { 
    // this is a pentagon
}