int cells [3][3] = {{0}};

jobjectArray
Java_com_packagename_appname_GameView_addNew(
        JNIEnv *env,
        jobject, int row, int col, int val) {

    cells[row][col] = val;

    // Get the int array class
    jclass cls = env->FindClass("[I");

    jintArray iniVal = env->NewIntArray(3);
    // Create the returnable jobjectArray with an initial value
    jobjectArray outer = env->NewObjectArray(3,cls, iniVal);

    for (int i = 0; i < 3; i++)
    {
        jintArray inner = env->NewIntArray(3);
        env->SetIntArrayRegion(inner, 0, 3, cells[i]);
        // set inner's values
        env->SetObjectArrayElement(outer, i, inner);
        env->DeleteLocalRef(inner);
    }
    return outer;
}