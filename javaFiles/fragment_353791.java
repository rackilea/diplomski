static inline void
check_java_exception(JNIEnv *env, int line)
{
    UNUSED(line);
    if(env->ExceptionOccurred()) {
#ifdef DEBUG
        fprintf(stderr, "Java exception at rlpjni.cpp line %d\n", line);
        env->ExceptionDescribe();
    abort();
#endif
        throw bt_rlpjni_java_is_upset();
    }
}