JNIEXPORT void JNICALL Java_org_libsdl_app_SDLActivity_nativeDemoInit(JNIEnv* env, jobject obj){
   jclass cls = (*env)->GetObjectClass(env,obj);  // instead of FindClass
   jmethodID mid = (*env)->GetMethodID(env, cls, "displayInterstitial2", "()V");
   if(!mid) return;  // method does not exist, should write some logs
   (*env)->CallVoidMethod(env, obj, mid);
}