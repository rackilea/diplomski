static jclass myCallbackClass;
static jmethodID myCallbackMethod;

/**
 * Call this method in JNI_OnLoad
 */ 
void CacheCallback()
{
    // Get a reference to the Callback class
    jclass clazz = (*env)->FindClass(env, "my/package/name/JNIReturnExample");

    // Store a global reference, since the local one will be freed when returning from the function.
    myCallbackClass = (*env)->NewGlobalRef(env, clazz);

    // Get a reference to the static callback method
    jmethodID callback = (*env)->GetStaticMethodID(env, myCallbackClass, "jniCallback", "(II)V");

    // jmethodID doesn't need a NewGlobalRef call
    myCallbackMethod = callback;
}

/**
 * Call this method in JNI_OnUnload
 */
void ReleaseCallback()
{
    (*env)->DeleteGlobalRef(env, myCallbackClass);
    myCallbackClass = NULL;

    // jmethodIDs are safe to keep without an explicit global reference, for this reason, we don't need to delete the reference either.
    myCallbackMethod = NULL;
}