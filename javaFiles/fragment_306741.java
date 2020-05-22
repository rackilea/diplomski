/* CLASS newInstance Method*/
jmethodID ClassNewInstanceMid = env->GetMethodID(Classcls, "newInstance","()Ljava/lang/Object;");



jobject myObject = env->CallObjectMethod(myJavaClass, ClassNewInstanceMid);