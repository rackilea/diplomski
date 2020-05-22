JNIEXPORT jobject JNICALL Java_physics_UserStream_toNxStreamPtr(JNIEnv *env, jobject userStreamObject) {
    jclass userStreamClass = env->GetObjectClass(userStreamObject);
    jmethodID getCPtrMethodID = env->GetStaticMethodID(userStreamClass, "getCPtr", "(Lphysics/UserStream;)J");

    jlong cPtr = env->CallStaticLongMethod(userStreamClass, getCPtrMethodID, userStreamObject);
    jboolean futureUse = false;

    jclass nxStreamPtrClass = env->FindClass("com/JPhysX/SWIGTYPE_p_NxStream");
    jmethodID nxStreamPtrConstructor = env->GetMethodID(nxStreamPtrClass, "<init>", "(JZ)V");
    jobject nxStreamPtrObject = env->NewObject(nxStreamPtrClass, nxStreamPtrConstructor, cPtr, futureUse);
    return nxStreamPtrObject;
}