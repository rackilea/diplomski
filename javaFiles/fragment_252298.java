System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
    // reading image 
    Mat image = Highgui.imread(".\\testing2.jpg", Highgui.CV_LOAD_IMAGE_GRAYSCALE);
    // clone the image 
    Mat original = image.clone();
    // thresholding the image to make a binary image
    Imgproc.threshold(image, image, 100, 128, Imgproc.THRESH_BINARY_INV);
    // find the center of the image
    double[] centers = {(double)image.width()/2, (double)image.height()/2};
    Point image_center = new Point(centers);

    // finding the contours
    ArrayList<MatOfPoint> contours = new ArrayList<MatOfPoint>();
    Mat hierarchy = new Mat();
    Imgproc.findContours(image, contours, hierarchy, Imgproc.RETR_EXTERNAL, Imgproc.CHAIN_APPROX_SIMPLE);

    // finding best bounding rectangle for a contour whose distance is closer to the image center that other ones
    double d_min = Double.MAX_VALUE;
    Rect rect_min = new Rect();
    for (MatOfPoint contour : contours) {
        Rect rec = Imgproc.boundingRect(contour);
        // find the best candidates
        if (rec.height > image.height()/2 & rec.width > image.width()/2)            
            continue;
        Point pt1 = new Point((double)rec.x, (double)rec.y);
        Point center = new Point(rec.x+(double)(rec.width)/2, rec.y + (double)(rec.height)/2);
        double d = Math.sqrt(Math.pow((double)(pt1.x-image_center.x),2) + Math.pow((double)(pt1.y -image_center.y), 2));            
        if (d < d_min)
        {
            d_min = d;
            rect_min = rec;
        }                   
    }
    // slicing the image for result region
    int pad = 5;        
    rect_min.x = rect_min.x - pad;
    rect_min.y = rect_min.y - pad;

    rect_min.width = rect_min.width + 2*pad;
    rect_min.height = rect_min.height + 2*pad;

    Mat result = original.submat(rect_min);     
    Highgui.imwrite("result.png", result);