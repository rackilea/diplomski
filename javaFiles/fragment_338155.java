jfloatArray Java_com_your_packagename_farrayFromJNI(JNIEnv *env, jobject thiz) {
    jfloatArray result;
    result = (*env)->NewFloatArray(env, 3);

    float* data;
    data = malloc(sizeof(float) * 3);
    data[0] = 123;  data[1] = 456;  data[2] = 789;

    (*env)->SetFloatArrayRegion(env, result, 0, 3, data);
    free(data);

    return result;
}