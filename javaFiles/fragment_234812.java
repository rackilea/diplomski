// Get the exception and clear as no
// JNI calls can be made while an exception exists.
jthrowable exception = pEnv->ExceptionOccurred();
pEnv->ExceptionClear();

jclass throwable_class = pEnv->FindClass("java/lang/Throwable");
jmethodID mid_throwable_getCause =
    pEnv->GetMethodID(throwable_class,
                      "getCause",
                      "()Ljava/lang/Throwable;");
jmethodID mid_throwable_getStackTrace =
    pEnv->GetMethodID(throwable_class,
                      "getStackTrace",
                      "()[Ljava/lang/StackTraceElement;");
jmethodID mid_throwable_toString =
    pEnv->GetMethodID(throwable_class,
                      "toString",
                      "()Ljava/lang/String;");

jclass frame_class = pEnv->FindClass("java/lang/StackTraceElement");
jmethodID mid_frame_toString =
    pEnv->GetMethodID(frame_class,
                      "toString",
                      "()Ljava/lang/String;");