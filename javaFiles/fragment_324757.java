const char* getCharFromString(JNIEnv* env, jstring string){
    if(string == NULL)
        return NULL;

    return  env->GetStringUTFChars(string ,0);
}