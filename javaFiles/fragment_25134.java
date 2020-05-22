float *cdataset;

JNIEXPORT void JNICALL
Java_Matcher_FlannLoadData(JNIEnv *env, jobject obj, jfloatArray d, jint r, jint c)
{
    ...
    cdataset = new float[rows*cols];
    ...
}

JNIEXPORT void JNICALL
Java_Matcher_FlannFreeData(JNIEnv *env, jobject obj)
{
    delete [] cdataset;
}