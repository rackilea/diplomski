void MyJNIFunction(JNIEnv *env, jobject object, jobjectArray stringArray) {

    int stringCount = env->GetArrayLength(stringArray);

    for (int i=0; i<stringCount; i++) {
        jstring string = (jstring) (env->GetObjectArrayElement(stringArray, i));
        const char *rawString = env->GetStringUTFChars(string, 0);
        // Don't forget to call `ReleaseStringUTFChars` when you're done.
    }
}