System.load("opencv_java320.dll");

    Mat dst = new Mat();
    Mat src = Imgcodecs.imread("path/to/your/image.png");

    // Converting to Grey Scale
    Imgproc.cvtColor(src, dst, Imgproc.COLOR_RGB2GRAY, 0);

    // Blurring/Smoothing
    Imgproc.GaussianBlur(dst, src, new Size(15.0,15.0),0.0,0.0);

    // Thresholding / Binarization
    Imgproc.threshold(src, dst, 150,255,Imgproc.THRESH_BINARY);
    Mat painted = new Mat(); // UPDATED
    src.copyTo(painted); // UPDATED

    // Invert colors (helps with dilation)
    Core.bitwise_not(dst,src);

    // Image Dilation
    Mat structuringElement = Imgproc.getStructuringElement(Imgproc.MORPH_RECT, new Size(55.0,55.0));
    Imgproc.dilate(src, dst, structuringElement);

    // Detect Text Areas
    List<Rect> textBlocks = findTextBlocks(dst);

    // Paint detected text areas
    paintTextBlocks(textBlocks, painted);