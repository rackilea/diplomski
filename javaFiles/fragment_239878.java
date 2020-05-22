JNIEXPORT jint JNICALL Java_Myclass_showMessage (JNIEnv* env, jobject obj, jstring title, jstring message, jint type)
{
    const jchar* _title = env->GetStringChars(title, 0);
    const jchar* _message = env->GetStringChars(message, 0);
    const int result = MessageBox(NULL, (wchar_t *) _message, (wchar_t *) _title, type);
    env->ReleaseStringChars(title, _title);
    env->ReleaseStringChars(message, _message);
    return result;
}