JNIEXPORT void JNICALL Java_com_idesign_opencvmaketest_MainActivity_train
        (JNIEnv *env, jobject thisObj, jlong images, jlong labels) {

Mat& matImage  = *(Mat*)images; //to create one Mat image, you need an array of Mat
Mat& matLabels = *(Mat*)labels; // create a Mat from labels

/*
To pass correct parameters, you would do:

std::vector<cv::Mat> vecImages;
vecImages.push_back(matImage);

std::vector<int> vecLabels;
//put your labels to vecLabels here

model->train(vecImages,vecLabels);
*/

Ptr<LBPHFaceRecognizer> model = LBPHFaceRecognizer::create();

/** make a call to 
*   CV_WRAP virtual void train(InputArrayOfArrays src, InputArray labels) = 0;
**/
model->train(matImages, matLabels); // function requires ArrayofMats and ArrayofInts
}