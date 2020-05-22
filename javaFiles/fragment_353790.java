jclass local = env->FindClass(CLS_JAVA_LANG_STRING);
_CHECK_JAVA_EXCEPTION(env);
java_lang_string_class = (jclass)env->NewGlobalRef(local);
_CHECK_JAVA_EXCEPTION(env);
env->DeleteLocalRef(local);
_CHECK_JAVA_EXCEPTION(env);