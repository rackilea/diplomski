extern "C" JNIEXPORT void JNICALL Java_com_example_ndkbuildtest_MainActivity_convertMap(JNIEnv *env, jobject thiz)
{
    // Obtain the Map instance and its class
    jclass main_activity_class = env->GetObjectClass(thiz);
    jmethodID get_the_map = env->GetStaticMethodID(main_activity_class, "getTheMap", "()Ljava/util/Map;");
    jobject java_map = env->CallStaticObjectMethod(main_activity_class, get_the_map);
    jclass map_class = env->GetObjectClass(java_map);

    // Obtain the key set and its class
    jclass set_class = env->FindClass("java/util/Set");
    jmethodID get_key_set = env->GetMethodID(map_class, "keySet", "()Ljava/util/Set;");
    jmethodID get_value = env->GetMethodID(map_class, "get", "(Ljava/lang/Object;)Ljava/lang/Object;");
    jobject java_key_set = env->CallObjectMethod(java_map, get_key_set);

    // Convert the key set to an array that we can iterate over easily
    jmethodID set_toarray = env->GetMethodID(set_class, "toArray", "()[Ljava/lang/Object;");
    jobjectArray java_key_array = static_cast<jobjectArray>(env->CallObjectMethod(java_key_set, set_toarray));
    jint len = env->GetArrayLength(java_key_array);

    // Insert all the key,value pairs into a std::map
    std::map<std::string, std::string> native_map;
    for (jint i = 0; i < len; ++i) {
        jstring java_key = static_cast<jstring>(env->GetObjectArrayElement(java_key_array, i));
        jstring java_value = static_cast<jstring>(env->CallObjectMethod(java_map, get_value, java_key));
        const char *key_chars = env->GetStringUTFChars(java_key, NULL);
        const char *value_chars = env->GetStringUTFChars(java_value, NULL);
        native_map.insert(std::pair<std::string, std::string>(key_chars, value_chars));
        env->ReleaseStringUTFChars(java_key, key_chars);
        env->ReleaseStringUTFChars(java_value, value_chars);
        env->DeleteLocalRef(java_key);
        env->DeleteLocalRef(java_value);
    }

    // Print the result
    for (const auto& kv : native_map) {
        __android_log_print(ANDROID_LOG_DEBUG, "convertMap", "nativeMap contains <%s, %s>", kv.first.c_str(), kv.second.c_str());
    }
}