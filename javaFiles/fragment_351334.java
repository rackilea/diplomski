int main()
{
    // the idea is that each int is 32 bit which is 4 channels of 8 bit color values instead of 3 channels, so assume a 4th channel.

    // first I create fake intArray which should be replaced by your input...
    const int imgWidth = 320;
    const int imgHeight = 210;
    int intArray[imgWidth*imgHeight]; // int array

    // fill the array with some test values:
    for(unsigned int pos = 0; pos < imgWidth*imgHeight; ++pos)
        intArray[pos] = 8453889; // 00000000 10000000 11111111 00000001 => R = 128, G = 255, B = 1
        //intArray[pos] = 65280;    // green
        //intArray[pos] = 16711680; // red
        //intArray[pos] = 255;  // blue

    // test:
    int firstVal = intArray[0];
    std::cout << "values: " << " int: " << firstVal << " R = " <<  ((firstVal >> 16) & 0xff) << " G = " << ((firstVal >> 8) & 0xff) << " B = " << (firstVal  & 0xff) << std::endl;

    // here you create the Mat and use your int array as input
    cv::Mat intMat_BGRA = cv::Mat(imgHeight,imgWidth,CV_8UC4, intArray); 
    // now you have a 4 channel mat with each pixel is one of your int, but with wrong order...
    std::cout << "BGRA ordering: " << intMat_BGRA.at<cv::Vec4b>(0,0) << std::endl;
    // this is in fact the BGRA ordering but you have to remove the alpha channel to get BGR values:
    // (unless you can live with BGRA values => you have to check whether there is garbage or 0s/255s in the byte area

    // so split the channels...
    std::vector<cv::Mat> BGRA_channels;
    cv::split(intMat_BGRA, BGRA_channels);

    // remove the alpha channel:
    BGRA_channels.pop_back();

    // and merge back to image:
    cv::Mat intMat_BGR;
    cv::merge(BGRA_channels, intMat_BGR);

    std::cout << "BGR ordering: " << intMat_BGR.at<cv::Vec3b>(0,0) << std::endl;

    cv::imshow("ordereed", intMat_BGR);

    cv::waitKey(0);
    return 0;
}