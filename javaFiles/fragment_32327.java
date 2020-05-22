JNIEXPORT jbyte JNICALL Java_CPSE_CPSC1900Connect(JNIEnv * env, jclass hPrinter, jbyte port, jstring Answer)
{

    const char* param = (*env)->GetStringUTFChars(env, Answer, 0);
    jbyte res = (jbyte)CPSC1900Connect((BYTE)port, (void*)param);

    (*env)->ReleaseStringUTFChars(env, Answer, param);

    return res;
}