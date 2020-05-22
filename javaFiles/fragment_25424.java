public void process(Mat rgbaImage) {
//Imgproc.pyrDown(rgbaImage, mPyrDownMat);
//Imgproc.pyrDown(mPyrDownMat, mPyrDownMat);

Imgproc.cvtColor(rgbaImage, mHsvMat, Imgproc.COLOR_RGB2HSV_FULL);

Core.inRange(mHsvMat, mLowerBound, mUpperBound, mMask);
Imgproc.dilate(mMask, mDilatedMask, new Mat());

List<MatOfPoint> contours = new ArrayList<MatOfPoint>();

Imgproc.findContours(mDilatedMask, contours, mHierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

// Find max contour area
double maxArea = 0;
Iterator<MatOfPoint> each = contours.iterator();
while (each.hasNext()) {
    MatOfPoint wrapper = each.next();
    double area = Imgproc.contourArea(wrapper);
    if (area > maxArea)
        maxArea = area;
}

// Filter contours by area and resize to fit the original image size
mContours.clear();
each = contours.iterator();
while (each.hasNext()) {
    MatOfPoint contour = each.next();
    if (Imgproc.contourArea(contour) > mMinContourArea*maxArea) {
        //Core.multiply(contour, new Scalar(4,4), contour);
        mContours.add(contour);
    }
}