Classifier *getClassifierInstance(JNIEnv *env, jobject obj) {
    jfieldID id = env->GetFieldID(env->GetObjectClass(obj), "_ptr", "J");
    return (id == NULL) ? NULL : ((Classifier *)env->GetLongField(obj, id));
}

JNIEXPORT jobjectArray JNICALL
Java_my_Classifier_classify(JNIEnv *env, jobject obj) {
    Classifier *classifier = getClassifierInstance(env, obj);
    char **ptr = classifier->classify();
    jobjectArray result = NewObjectArray(env, MATRIX_HEIGHT, FindClass(env, "[B"), NewByteArray(env, 0));
    for (int i = 0; i < MATRIX_HEIGHT; ++i) {
        jbyteArray row = NewByteArray(env, MATRIX_WIDTH);
        SetByteArrayRegion(env, row, 0, MATRIX_WIDTH, ptr[i]);
        SetObjectArrayElement(env, result, i, row);
    }
    return result;
}