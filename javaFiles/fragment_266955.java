IplImage *img = cvLoadImage( argv[1], CV_LOAD_IMAGE_COLOR );
CvCapture* capture = cvCaptureFromCAM( CV_CAP_ANY );
while ( 1 ) {
    IplImage* frame = cvQueryFrame( capture );
    //match(img,frame);
}
cvReleaseCapture( &capture );