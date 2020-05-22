private int outputWidth=300;
private int outputHeight=200;
private Mat mOutputROI;

private boolean bpUpdated = false;

private Mat mRgba;
private Mat mHSV;
private Mat mask;

private int lo = 20; 
private int up = 20;

public void onCameraViewStarted(int width, int height) {

    mRgba = new Mat(height, width, CvType.CV_8UC3);
    mHSV = new Mat();
    mIntermediateMat = new Mat();
    mGray = new Mat(height, width, CvType.CV_8UC1);
    mOutputROI = new Mat(outputHeight, outputWidth, CvType.CV_8UC1);

    mBitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);        
}

public Mat onCameraFrame(CvCameraViewFrame inputFrame) {
    Mat mCamera = inputFrame.rgba();

    Imgproc.cvtColor(mCamera, mRgba, Imgproc.COLOR_RGBA2RGB);

    Mat mOutputROI = mCamera.submat(0, outputHeight, 0, outputWidth);

    //Addition to remove some noise:
    Imgproc.GaussianBlur(mRgba, mRgba, new Size(5, 5), 0, Imgproc.BORDER_DEFAULT);

    Imgproc.cvtColor(mRgba, mHSV, Imgproc.COLOR_RGB2HSV_FULL);

    if(mask!=null){
        if(bpUpdated==false){
            mGray = histAndBackproj();
        } else {
            bpUpdated = false;
        }

        Imgproc.resize(mGray, mIntermediateMat, mOutputROI.size(), 0, 0, Imgproc.INTER_LINEAR);
        Imgproc.cvtColor(mIntermediateMat, mOutputROI, Imgproc.COLOR_GRAY2BGRA);
    }

    return mCamera;
}

public boolean onTouch(View arg0, MotionEvent arg1) {       
    Point seed = getImageCoordinates(mRgba, arg1.getX(), arg1.getY());

    int newMaskVal = 255;
    Scalar newVal = new Scalar( 120, 120, 120 );

    int connectivity = 8;
    int flags = connectivity + (newMaskVal << 8 ) + Imgproc.FLOODFILL_FIXED_RANGE + Imgproc.FLOODFILL_MASK_ONLY;

    Mat mask2 = Mat.zeros( mRgba.rows() + 2, mRgba.cols() + 2, CvType.CV_8UC1 );

    Rect rect = null;
    Imgproc.floodFill( mRgba, mask2, seed, newVal, rect, new Scalar( lo, lo, lo ), new Scalar( up, up, up), flags );

    // C++: 
    // mask = mask2( new Range( 1, mask2.rows() - 1 ), new Range( 1, mask2.cols() - 1 ) );
    mask = mask2.submat(new Range( 1, mask2.rows() - 1 ), new Range( 1, mask2.cols() - 1 ));

    mGray = histAndBackproj();
    bpUpdated = true;           

    return true;
}

  private Mat histAndBackproj() {
    Mat hist = new Mat();
    int h_bins = 30; 
    int s_bins = 32;

    // C++:
    //int histSize[] = { h_bins, s_bins };
    MatOfInt mHistSize = new MatOfInt (h_bins, s_bins);

    // C++:
    //float h_range[] = { 0, 179 };
    //float s_range[] = { 0, 255 };     
    //const float* ranges[] = { h_range, s_range };     
    //int channels[] = { 0, 1 };

    MatOfFloat mRanges = new MatOfFloat(0, 179, 0, 255);
    MatOfInt mChannels = new MatOfInt(0, 1);

    // C++:
    // calcHist( &hsv, 1, channels, mask, hist, 2, histSize, ranges, true, false );

    boolean accumulate = false;
    Imgproc.calcHist(Arrays.asList(mHSV), mChannels, mask, hist, mHistSize, mRanges, accumulate);

    // C++:
    // normalize( hist, hist, 0, 255, NORM_MINMAX, -1, Mat() );        
    Core.normalize(hist, hist, 0, 255, Core.NORM_MINMAX, -1, new Mat());

    // C++:
    // calcBackProject( &hsv, 1, channels, hist, backproj, ranges, 1, true );        
    Mat backproj = new Mat();
    Imgproc.calcBackProject(Arrays.asList(mHSV), mChannels, hist, backproj, mRanges, 1);

    return backproj;
}


/**
 * Method to scale screen coordinates to image coordinates, 
 * as they have different resolutions.
 * 
 * x - width; y - height; 
 * Nexus 4: xMax = 1196; yMax = 768
 * 
 * @param displayX
 * @param displayY
 * @return
 */
private Point getImageCoordinates(Mat image, float displayX, float displayY){
    Display display = getWindowManager().getDefaultDisplay();       
    android.graphics.Point outSize = new android.graphics.Point();
    display.getSize(outSize);

    float xScale = outSize.x / (float) image.width();
    float yScale = outSize.y / (float) image.height();                  

    return new Point(displayX/xScale, displayY/yScale);
}