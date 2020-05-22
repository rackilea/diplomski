void ThreadProc(JNIEnv* env, jobject runnable)
{
    jclass RunnableInterface = env->GetObjectClass(runnable);
    jmethodID Run = env->GetMethodID(RunnableInterface, "run","()V");
    env->CallObjectMethod(RunnableInterface, Run);
}

JNIEXPORT void JNICALL Java_JNIExample_StartNativeThread(JNIEnv* env, jobject obj, jobject runnable)
{
    std::thread(ThreadProc, env, obj).detach();
}