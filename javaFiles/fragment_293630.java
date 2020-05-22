// Returns a 2D float array from C to Java
jobjectArray ndk_test_getMy2DArray(JNIEnv* env, jobject thiz, jlong context)
{
    // Cast my context reference
    MyContextRef contextRef = (MyContextRef) context;

    // Get the length for the first and second dimensions
    unsigned int length1D = MyContextGet1DLength(contextRef);
    unsigned int length2D = MyContextGet2DLength(contextRef);

    // Get the 2D float array we want to "Cast"
    float** primitive2DArray = MyContextGet2DArray(contextRef);

    // Get the float array class
    jclass floatArrayClass = (*env)->FindClass(env, "[F");

    // Check if we properly got the float array class
    if (floatArrayClass == NULL)
    {
        // Ooops
        return NULL;
    }

    // Create the returnable 2D array
    jobjectArray myReturnable2DArray = (*env)->NewObjectArray(env, (jsize) length1D, floatArrayClass, NULL);

    // Go through the firs dimension and add the second dimension arrays
    for (unsigned int i = 0; i < length1D; i++)
    {
        jfloatArray floatArray = (*env)->NewFloatArray(env, length2D);
        (*env)->SetFloatArrayRegion(env, floatArray, (jsize) 0, (jsize) length2D, (jfloat*) primitive2DArray[i]);
        (*env)->SetObjectArrayElement(env, myReturnable2DArray, (jsize) i, floatArray);
        (*env)->DeleteLocalRef(env, floatArray);
    }

    // Return a Java consumable 2D float array
    return myReturnable2DArray;
}