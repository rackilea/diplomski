JNIEXPORT jintArray JNICALL Java_ArrayTest_initIntArray(JNIEnv *env, jclass cls, int size)
{
 jintArray result;
 result = (*env)->NewIntArray(env, size);
 if (result == NULL) {
     return NULL; /* out of memory error thrown */
 }
 int i;
 // fill a temp structure to use to populate the java int array
 jint fill[size];
 for (i = 0; i < size; i++) {
     fill[i] = 0; // put whatever logic you want to populate the values here.
 }
 // move from the temp structure to the java structure
 (*env)->SetIntArrayRegion(env, result, 0, size, fill);
 return result;
}