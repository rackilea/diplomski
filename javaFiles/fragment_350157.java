JNIEXPORT void JNICALLJava_MyJavaClass_printName(JNIEnv *env, jobject obj, jstring name)
{
    const char *str= (*env)->GetStringUTFChars(env,name,0);
    printf(“%s”, str);
    //need to release this string when done with it in order to
    //avoid memory leak
    (*env)->ReleaseStringUTFChars(env, name, str);
}