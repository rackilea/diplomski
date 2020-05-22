extern "C"
{
JNIEXPORT jfloatArray JNICALL Java_com_your_packagename_farrayFromJNI(JNIEnv *env, jobject thiz) {

jfloatArray result;
    result = env->NewFloatArray(3);

    float* data;
    data = malloc(sizeof(float) * 3);
    data[0] = 123;  data[1] = 456;  data[2] = 789;

    env->SetFloatArrayRegion(result, 0, 3, data);
    free(data);
    return result;
};
}