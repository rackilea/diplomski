jbyteArray Java_com_googlecode_leptonica_android_Pix_nativeGetData(
        JNIEnv *env, jclass clazz, jlong nativePix) {
    PIX *pix = (PIX *) nativePix;
    // Get the size
    size_t size = 4 * pixGetWpl(pix) * pixGetHeight(pix);

    jbyteArray  result = env->NewByteArray(size);
    if (result == NULL) {
        LOGE("Cannot allocate JNI Byte Array");

        return NULL; /* out of memory error thrown */
    }
    // move from the Pix to the java structure
    env->SetByteArrayRegion(result, 0, size,(jbyte*)pixGetData(pix));
    return result;
}