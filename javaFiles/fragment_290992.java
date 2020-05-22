class CxxGameEngine;

JNIEXPORT jlong JNICALL GameEngine_loadEngine(JNIEnv *env, jobject obj) {
     return (jlong)(new CxxGameEngine(params));
}

JNIEXPORT jvoid JNICALL GameEngine_destroyEngine(JNIEnv *env, jobject obj, jlong nativePointer) {
     delete (CxxGameEngine *)nativePointer;
}

JNIEXPORT jdouble JNICALL GameEngine_nativePlayGameOrWhatever(JNIEnv *env, jobject obj, jlong nativePointer) {
     return ((CxxGameEngine *)nativePointer)->playGameOrWhatever();
}