const char* GetIDJni() {

    JniMethodInfo t;

        if (JniHelper::getStaticMethodInfo(t, CLASS_NAME, "GetIDJni", "()Ljava/lang/String;")) {
            jstring str = (jstring)t.env->CallStaticObjectMethod(t.classID, t.methodID);
            t.env->DeleteLocalRef(t.classID);
            CCString *ret = new CCString(JniHelper::jstring2string(str).c_str());
            ret->autorelease();
            t.env->DeleteLocalRef(str);

            return ret->m_sString.c_str();
        }

        return 0;
    }