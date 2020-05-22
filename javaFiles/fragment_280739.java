// for example to shift a circluar hue-channel
cv::Mat shiftChannel(cv::Mat H, int shift, int maxVal = 180)
{
    // CV_8UC1 only!
    cv::Mat shiftedH = H.clone();
    //int shift = 25; // in openCV hue values go from 0 to 180 (so have to be doubled to get to 0 .. 360) because of byte range from 0 to 255
    for (int j = 0; j < shiftedH.rows; ++j)
    for (int i = 0; i < shiftedH.cols; ++i)
    {
        shiftedH.at<unsigned char>(j, i) = (shiftedH.at<unsigned char>(j, i) + shift) % maxVal;
    }

    return shiftedH;
}

cv::Mat thresholdHue(cv::Mat hsvImage, int hueVal, int range = 30, int minSat = 50, int minValue = 50)
{
    // hsvImage must be CV_8UC3 HSV image.
    // hue val and range are in openCV's hue range (0 .. 180)
    // range shouldnt be bigger than 90, because that's max (all colors), after shifting the hue channel.

    // this function will
    //    1. shift the hue channel, so that even colors near the border (red color!) will be detectable with same code.
    //    2. threshold the hue channel around the value 90 +/- range

    cv::Mat mask; // return-value

    std::vector<cv::Mat> channels;
    cv::split(hsvImage, channels);

    int targetHueVal = 180 / 2; // we'll shift the hue-space so that the target val will always be 90 afterwards, no matter which hue value was chosen. This can be important if 
    int shift = targetHueVal - hueVal;
    if (shift < 0) shift += 180;

    cv::Mat shiftedHue = shiftChannel(channels[0], shift, 180);

    // merge the channels back to hsv image
    std::vector<cv::Mat> newChannels;
    newChannels.push_back(shiftedHue);
    newChannels.push_back(channels[1]);
    newChannels.push_back(channels[2]);
    cv::Mat shiftedHSV;
    cv::merge(newChannels, shiftedHSV);

    // threshold
    cv::inRange(shiftedHSV, cv::Vec3b(targetHueVal - range, minSat, minValue), cv::Vec3b(targetHueVal + range, 255, 255), mask);

    return mask;
}


int main(int argc, char* argv[])
{
    cv::Mat input = cv::imread("C:/StackOverflow/Input/redCircleLikeContours.jpg");


    cv::Mat redMask; 

    cv::Mat hsv;
    cv::cvtColor(input, hsv, CV_BGR2HSV);

    redMask = thresholdHue(hsv, 0, 20, 50, 50);

    cv::imshow("red", redMask);

    cv::imshow("input", input);
    cv::imwrite("C:/StackOverflow/Output/redCircleLikeContoursMask.png", redMask);

    cv::waitKey(0);
    return 0;
}