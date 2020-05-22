JNIEXPORT void JNICALL Java_my_package_name_JNIReturnExample_returnWithJavaCallback(JNIEnv *env, jobject javaThis, jfloat param1, jfloat param2)
{
    // Get the class of the current calling object
    jclass clazz = (*env)->GetObjectClass(env, javaThis);

    // Get the method id of the instance method: void javaCallback(float, float) in my.package.name.JNIReturnExample
    jmethodID callback = (*env)->GetMethodID(env, clazz, "javaCallback", "(FF)V");

    // Calls my.package.name.JNIReturnExample#javaCallback(float, float);
    (*env)->CallVoidMethod(env, javaThis, callback, param1, param2);
}