JNIEXPORT void JNICALL Java_my_package_name_JNIReturnExample_setObjectFields(JNIEnv *env, jobject javaThis, jobject obj, jfloat param1, jfloat param2)
{
    // Get the class of the input object
    jclass clazz = (*env)->GetObjectClass(env, obj);

    // Get Field references
    jfieldID param1Field = (*env)->GetFieldID(env, clazz, "param1", "F");
    jfieldID param2Field = (*env)->GetFieldID(env, clazz, "param2", "F");

    // Set fields for object
    (*env)->SetFloatField(env, obj, param1Field, param1);
    (*env)->SetFloatField(env, obj, param2Field, param2);
}