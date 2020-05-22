JavaVM* g_jvm = 0;
JNIEXPORT void JNICALL package_initJNI(JNIEnv* en, jobject ob)
{
    ....
    // insted of the env store the VM
    en->GetJavaVM(&g_jvm);
    obj = en->NewGlobalRef(ob); // I don't think you need this
    // and at some point you must delete it again
    ....
}

JNIEXPORT void JNICALL package_endTrialJava(){
    JNIEnv* env;
    g_jvm->AttachCurrentThread(&env, NULL); // check error etc
    jobject javaObjectRef = env->NewObject(javaClassRef, javaMethodRef);
    // this line makes not much sense. I think you don't need it if you use the global
    // with the global it would be more like this
    env->CallVoidMethod(obj javaMethodRef);
}