Mat currentFrame = new Mat(), hsv = new Mat(), threshImage = new Mat();
List<MatOfPoint> contours = new ArrayList<MatOfPoint>();

while (true) {
    camera.read(currentFrame);

    Imgproc.resize(currentFrame, currentFrame, new Size(WIDTH, HEIGHT));
    Imgproc.cvtColor(currentFrame, hsv, Imgproc.COLOR_RGB2HSV);

    hsvWindow.showImage(hsv);

    Core.inRange(hsv, new Scalar(50, 100, 50), new Scalar(95, 255, 255), threshImage);
    Imgproc.blur(threshImage, threshImage, new Size(10, 10));
    Imgproc.threshold(threshImage, threshImage, 150, 255, Imgproc.THRESH_BINARY);

    threshWindow.showImage(threshImage);

    Imgproc.findContours(threshImage, contours, new Mat(), Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);
    double maxArea = 0;
    float[] radius = new float[1];
    Point center = new Point();
    for (int i = 0; i < contours.size(); i++) {
        MatOfPoint c = contours.get(i);
        if (Imgproc.contourArea(c) > maxArea) {
            MatOfPoint2f c2f = new MatOfPoint2f(c.toArray());
            Imgproc.minEnclosingCircle(c2f, center, radius);
        }
    }
    Core.circle(currentFrame, center, (int)radius[0], new Scalar(255, 0, 0), 2);

    drawWindow.showImage(currentFrame);
}