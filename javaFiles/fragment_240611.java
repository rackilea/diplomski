jint JNICALL stringCallback(jlong class_tag, jlong size, jlong* tag_ptr,
                            const jchar* value, jint value_length, void* user_data) {
    wprintf(L"%.*s\n", value_length, value);
    return 0;
}

JNIEXPORT void JNICALL Java_HeapIterator_printStrings(JNIEnv* env, jclass cls) {
    jvmtiHeapCallbacks callbacks = {NULL, NULL, NULL, NULL, stringCallback};
    (*jvmti)->IterateThroughHeap(jvmti, 0, NULL, &callbacks, NULL);
}