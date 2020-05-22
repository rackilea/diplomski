IplImage src = cvLoadImage(path);//hear path is actual path to image
    IplImage grayImage    = IplImage.create(src.width(), src.height(), IPL_DEPTH_8U, 1);
    cvCvtColor(src, grayImage, CV_RGB2GRAY);
    cvThreshold(grayImage, grayImage, 127, 255, CV_THRESH_BINARY);
    CvSeq cvSeq=new CvSeq();
    CvMemStorage memory=CvMemStorage.create();
    cvFindContours(grayImage, memory, cvSeq, Loader.sizeof(CvContour.class), CV_RETR_LIST, CV_CHAIN_APPROX_SIMPLE);