JNIEXPORT jfloatArray JNICALL
TENSORFLOW_METHOD(detectDigit)(JNIEnv* env, jobject thiz, jintArray raw_pixels) {

    jfloatArray newArray = env->NewFloatArray(2);
    jint* pixels = env->GetIntArrayElements(raw_pixels, NULL);

    jfloat *result = process( reinterpret_cast<int*>(pixels) );

    env->ReleaseIntArrayElements(raw_pixels, pixels, JNI_ABORT);
    env->SetFloatArrayRegion(newArray, 0, 2, result);

    free(result);

    return newArray;
}