jclass j_Integer = env->FindClass("java/lang/Integer");
jmethodID j_Integer_valueOf = env->GetStaticMethodID(j_Integer, "valueOf", "(I)Ljava/lang/Integer;");
jmethodID put = env->GetMethodID(mapClass, "put", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");

for (auto &it: m_values) {
    jobject j_intValue = env->CallStaticObjectMethod(j_Integer, j_Integer_valueOf, it.second);
    env->CallObjectMethod(hashMap, put, env->NewStringUTF(it.first.c_str()), j_intValue);
}