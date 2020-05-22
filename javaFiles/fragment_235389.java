//Optional, this is just so that I can retrieve the C++ MyLibrary instance
//easily from the Java.
JNIEXPORT void JNICALL Java_MyLibrary_initCpp(JNIEnv* env, jobject javaMyLibrary) {
    //Save the C++ version of MyLibrary as a field inside the Java MyLibrary.
    MyLibrary * lib = new MyLibrary();
    env->SetLongField(javaMyLibrary, CPP_MYLIBRARY_POINTER_FIELD, ptr_to_jlong(lib));
}

JNIEXPORT void JNICALL Java_MyLibrary_setObserver(JNIEnv* env, 
        jobject javaMyLibrary, jobject javaObserver) {
    //Retrieve the CPP version of MyLibrary. For me, I stored it inside the java
    //object as a field, but you can implement it any way you want.
    MyLibrary* cppMyLibrary = (MyLibrary*)jlong_to_ptr(
        env->GetLongField(javaMyLibrary, CPP_MYLIBRARY_POINTER_FIELD));
    if (cppMyLibrary == NULL) {
        //Handle the problem
        return;
    }
    jthrowable exc = NULL;

    //Keep the jvm object around; the env is not available in another thread
    //but can be obtained from the jvm.
    JavaVM* jvm;
    env->GetJavaVM(&jvm);

    //The observer has to be made global; it's not available in another thread.
    jobject observer = env->NewGlobalRef(javaObserver);
    //TODO: retrieve the previous observer and clean it up with DeleteGlobalRef()
    //TODO: clean up this observer when destroying MyLibrary with DeleteGlobalRef()

    try {
        //At this point, both "jvm" and "observer" are accessible from the other thread.
        cppMyLibrary->setLogFunction([jvm, observer] (std::string& p0, std::string& p1) {
            JNIEnv* env;
            jvm->AttachCurrentThread(&env, NULL); //Obtain the env
            jclass clazz = env->GetObjectClass(observer);
            jmethodID meth = env->GetMethodID(clazz, "log",
                    "(Ljava/lang/String;Ljava/lang/String;)V");
            jstring s0 = env->NewStringUTF(p0.c_str());
            jstring s1 = env->NewStringUTF(p1.c_str());
            env->CallVoidMethod(observer, meth, s0, s1);

            //TODO: make sure this is called even if there's an exception!
            jvm->DetachCurrentThread();
        });
    } catch (...) {
        exc = //handle your exceptions here
    }

    if (exc != NULL) {
        env->Throw(exc);
    }
}