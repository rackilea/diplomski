extern "C"
{
    #include "com_example_nativeapp_MainActivity.h"

    JNIEXPORT jstring JNICALL Java_com_example_nativeapp_MainActivity_testNativeMethod(JNIEnv* env, jobject obj)
    {
        return env->NewStringUTF("HELLO FROM C Native!");
    }
}