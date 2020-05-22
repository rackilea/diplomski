JNIEXPORT jobject JNICALL Java_com_example_helloworld_Tester_getData
          (JNIEnv* env, jclass clasz, jbyteArray dataByteArray, jint sizeDataByteArray) {
    const char* cls_name = "com/example/helloworld/ReturnValue";
    // try to obtain ReturnValue class
    jclass cls = env->FindClass(cls_name);
    // if exception occurred return control to java 
    if (env->ExceptionOccurred())
        return NULL;

    const char* constructor_signature = "(Z[B)V";
    // try to obtain ReturnValue constructor
    jmethodID constructorId = env->GetMethodID(cls, "<init>", constructor_signature);
    // if exception occurred return control to java 
    if (env->ExceptionOccurred())
            return NULL;

    jboolean success = true;
    jbyteArray data = env->NewByteArray(0);

    // fill data array...

    // create ReturnValue object. If exception occurred, 
    // control will be returned java automatically in this case
    return env->NewObject(cls, constructorId, success, data);
}