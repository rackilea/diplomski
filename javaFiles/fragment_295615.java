JNIEXPORT void JNICALL 
Java_ImageConversion_covertBytes(JNIEnv *env, jobject obj, jbyteArray array) 
{
    void *flag = (*env)->GetByteArrayElements(env, array, NULL);
    jsize size = (*env)->GetArrayLength(env, array);
    fwrite(flag, 1, size, stdout);     
}