// In C++
JNIEXPORT jboolean JNICALL
VeryLongName_nativeCanny(JNIEnv *env, jobject instance, long iAddr) {
    cv::Mat* img = (cv::Mat*) iAddr;
    cv::Canny(*img, *img, 80, 100, 3);
    return true;
}