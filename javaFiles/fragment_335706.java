// Get an array of Objects corresponding to the Collection
jclass collClass = env->FindClass("java/util/Collection");
jmethodID collToArray = env->GetMethodID(collClass, "toArray", "()[Ljava/lang/Object;");
jobjectArray integerArray = (jobjectArray) env->CallObjectMethod(intColl, collToArray);

// Get the first element from the array, and then extract its value as an int
jclass integerClass = env->FindClass("java/lang/Integer");
jmethodID intValue = env->GetMethodID(integerClass, "intValue", "()I");
jobject firstInteger = (jobject) env->GetObjectArrayElement(integerArray, 0);
int i = env->CallIntMethod(firstInteger, intValue);

__android_log_print(ANDROID_LOG_VERBOSE, "Test", "The value of the first Integer is %d", i);

env->DeleteLocalRef(firstInteger);
env->DeleteLocalRef(integerArray);