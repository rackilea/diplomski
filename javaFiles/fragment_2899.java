JNIEXPORT void JNICALL Java_pl_pelotasplus_actionafteruninstall_MainActivity_observer
      (JNIEnv *env, jobject thiz, jstring email){

   const char *nativeEmailString = (*env)->GetStringUTFChars(env, email, 0);

   // use your string

   (*env)->ReleaseStringUTFChars(env, email, nativeEmailString);
}