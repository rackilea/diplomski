/*
* Class:     com_neohope_jni_test_LowerCaseTokenizer
* Method:    Initialize
* Signature: (Ljava/io/Reader;)V
*/
JNIEXPORT void JNICALL Java_com_neohope_jni_test_LowerCaseTokenizer_Initialize
(JNIEnv *env, jobject caller, jobject reader)
{
    getJniClassName(env, caller);
    getJniClassName(env, reader);

    jclass clazz = (*env)->GetObjectClass(env, reader);
    if (clazz == NULL)return;

    jmethodID midRead01 = (*env)->GetMethodID(env, clazz, "read", "()I");
    jmethodID midRead02 = (*env)->GetMethodID(env, clazz, "read", "([C)I");
    jmethodID midRead03 = (*env)->GetMethodID(env, clazz, "read", "([CII)I");

    //do your job here
    if (midRead01 == NULL)return;
    jint ret = (*env)->CallIntMethod(env, reader, midRead01);
    printf("%l", ret);
}