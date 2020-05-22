public Mat getFaceMask(Mat image){

    List<Point> faceConvexHull = new ArrayList<>();
    faceConvexHull.add(new Point(197, 154));
    faceConvexHull.add(new Point(190, 197));
    faceConvexHull.add(new Point(182, 217));
    faceConvexHull.add(new Point(170, 234));
    faceConvexHull.add(new Point(155, 251));
    faceConvexHull.add(new Point(138, 264));
    faceConvexHull.add(new Point(121, 268));
    faceConvexHull.add(new Point(104, 265));
    faceConvexHull.add(new Point(88, 253));
    faceConvexHull.add(new Point(73, 238));
    faceConvexHull.add(new Point(61, 221));
    faceConvexHull.add(new Point(51, 202));
    faceConvexHull.add(new Point(46, 181));
    faceConvexHull.add(new Point(42, 159));
    faceConvexHull.add(new Point(41, 137));
    faceConvexHull.add(new Point(49, 116));
    faceConvexHull.add(new Point(73,  95));
    faceConvexHull.add(new Point(164,  95));
    faceConvexHull.add(new Point(190, 115));
    faceConvexHull.add(new Point(197, 133));

    org.opencv.core.Point [] pointArray = new org.opencv.core.Point[faceConvexHull.size()];

    Point pt;
    for(int i = 0; i < faceConvexHull.size(); i++){
        pt = faceConvexHull.get(i);
        pointArray[i] = new org.opencv.core.Point(pt.x, pt.y);
    }



    Mat faceMask =  Mat.zeros(image.size(), CV_8UC3);

    MatOfPoint points = new MatOfPoint(pointArray);

    fillConvexPoly(faceMask, points, new Scalar(255, 255, 255));

    return faceMask;
}