JNIEXPORT jstring JNICALL
Java_net_jni_test_MainActivity_callTest(JNIEnv *env, jobject instance) {
    jstring stringValue = (*env)->NewStringUTF(env, "test");

    jclass stringClass = (*env)->FindClass(env, "java/lang/String");
    jmethodID getBytesMId = (*env)->GetMethodID(env, stringClass, "getBytes", "()[B");

    jbyteArray keyBytes = (jbyteArray)(*env)->CallObjectMethod(env, stringValue, getBytesMId);

    // determine the needed length and allocate a buffer for it
    jsize num_bytes = (*env)->GetArrayLength(env, keyBytes);


    // obtain the array elements
    jbyte* elements = (*env)->GetByteArrayElements(env, keyBytes, NULL);
    if (!elements) {
        // handle JNI error ...
    }

    for(int i = 0; i < num_bytes; i++) {
        char ch = elements[i];
        ALOGI("arrayLength: %c", ch);
    }

    // Do not forget to release the element array provided by JNI:
    (*env)->ReleaseByteArrayElements(env, keyBytes, elements, JNI_ABORT);
}