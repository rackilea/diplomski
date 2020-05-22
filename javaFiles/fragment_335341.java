JNIEXPORT jint JNICALL 
 Java_IntArray_doStuffArray(JNIEnv *env, jobject obj, jintArray arr)
 {

     // initializations, declarations, etc
     jint *c_array;
     jint i = 0;

     // get a pointer to the array
     c_array = (*env)->GetIntArrayElements(env, arr, NULL);

     // do some exception checking
     if (c_array == NULL) {
         return -1; /* exception occurred */
     }

     // do stuff to the array
     for (i=0; i<10; i++) {
         c_array[i] = i;
     }

     // release the memory so java can have it again
     (*env)->ReleaseIntArrayElements(env, arr, c_array, 0);

     // return something, or not.. it's up to you
     return 0;
 }