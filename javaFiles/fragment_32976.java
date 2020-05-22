static jobject window1=nullptr;
static jobject window2=nullptr;

Java_your_prefix_class_startPreview(JNIEnv *env,jobject thiz,jobject window){
    window1=env->NewGlobalRef(window);
}

Java_your_prefix_class_snapshot(JNIEnv *env,jobject thiz,jobject window){
    window2=env->NewGlobalRef(window);

    TDebug("windows are equal = %d", env->IsSameObject(window1, window2));
}