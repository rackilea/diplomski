int getBytesNeededByString(JNIEnv* env, jstring string){
    return env->GetStringUTFLength(string);
}

int getNumberOfCharsInString(JNIEnv* env, jstring string){
    return env->GetStringLength(string);
}