JNIEXPORT jobject JNICALL Java_my_package_name_JNIReturnExample_returnObjectValue(JNIEnv *env, jobject javaThis, jfloat param1, jfloat param2)
{
    // Get the class we wish to return an instance of
    jclass clazz = (*env)->FindClass(env, "my/package/name/JNIReturnObject");

    // Get the method id of an empty constructor in clazz
    jmethodID constructor = (*env)->GetMethodID(env, clazz, "<init>", "()V");

    // Create an instance of clazz
    jobject obj = (*env)->NewObject(env, clazz, constructor);

    // Get Field references
    jfieldID param1Field = (*env)->GetFieldID(env, clazz, "param1", "F");
    jfieldID param2Field = (*env)->GetFieldID(env, clazz, "param2", "F");

    // Set fields for object
    (*env)->SetFloatField(env, obj, param1Field, param1);
    (*env)->SetFloatField(env, obj, param2Field, param2);

    // return object
    return obj;
}