env->PushLocalFrame(256); // fix for local references

jclass hashMapClass= env->FindClass(env, "java/util/HashMap");
jmethodID hashMapInit = env->GetMethodID(env, hashMapClass, "<init>", "(I)V");
jobject hashMapObj = env->NewObject(env, hashMapClass, hashMapInit, mMap.size());
jmethodID hashMapOut = env->GetMethodID(env, hashMapClass, "put",
            "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;");

for (auto it : mMap)
{
    env->CallObjectMethod(env, hashMap, put,
         env->NewStringUTF(it->first.c_str()),
         env->NewStringUTF(it->second.c_str()));
}

env->PopLocalFrame(hashMap);

return hashMap;