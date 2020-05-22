extern "C" JNIEXPORT void JNICALL Java_com_example_nonfreejnidemo_NonfreeJNILib_extractorSuTarget(JNIEnv * env, jobject obj, jint nT )
{
   .....

    Mat object[50];

  // read 50 image and put them in object[i]
        for (unsigned int i = 0;i < 50 ;i++) {
            object[i] = imread( files[i], CV_LOAD_IMAGE_GRAYSCALE );
        }

        //Detect the keypoints using SURF Detector
        int minHessian = 500;

        SurfFeatureDetector detector( minHessian );
        std::vector<KeyPoint> kp_object[nT];


        for (unsigned int i = 0;i < nT; i++)
        {
            detector.detect( object[i], kp_object[i] );
        }

        //Calculate descriptors (feature vectors)
        SurfDescriptorExtractor extractor;

        Mat* des_object = new Mat[nT]();

        for (unsigned int i = 0;i < nT; i++)
        {
             extractor.compute( object[i], kp_object[i], des_object[i] );

        }
        jclass cls = env->GetObjectClass(obj);
        jmethodID methodId = env->GetMethodID( cls, "setTarget", "(J)V");
        env->CallVoidMethod(obj, methodId, (jlong)des_object);

}