// Draw lines on the canny contour image
val colorDst = cvCreateImage(cvGetSize(src), src.depth(), 3)
cvCvtColor(src, colorDst, CV_GRAY2BGR)
for (i <- 0 until circles.total) {
    val point = new CvPoint3D32f(cvGetSeqElem(circles, i))
    val center = cvPointFrom32f(new CvPoint2D32f(point.x, point.y))
    val radius = math.round(point.z)
    cvCircle(colorDst, center, radius, CV_RGB(255, 0, 0), 1, CV_AA, 0)
    print(point)
}
show(colorDst, "Hough Circles")