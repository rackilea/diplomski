protected boolean init () throws UnableToLoadImage{
    imgx = new IplImage();    // Create a new IplImage() even though we won't use it

    imgxc1 = new IplImage();  // Same here. Just food for the garbage collector

    imgxd1 = new IplImage();  // Third completely unnecessary object creation

    imgx = cvLoadImage(path+DR+filename);  // Load an image, the previously created object in imgx is now GC food

    if(imgx == null)throw new UnableToLoadImage(path+DR+filename);
    //cvSaveImage("debug/"+filename, imgx);

    imgxc1 = cvCreateImage(cvGetSize(imgx), imgx.depth(), imgx.nChannels());  // Create an image with native resources, previous object is GC food

    imgxc1 = imgx.clone();    // Third time assignment to imgxc1, previous object isn't GC food since it holds native resources
    imgxd1 = cvCreateImage(cvGetSize(imgx), IPL_DEPTH_8U, 1);  // The first proper use of cvCreateImage
    cvCvtColor(imgxc1, imgxd1, CV_BGR2GRAY);  // Presumably ok
    return (imgx != null && imgxc1 != null && imgxd1 != null)?true:false;  // Doesn't need the ternary operator at all
}