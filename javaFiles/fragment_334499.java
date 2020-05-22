jclass mainClass = env->FindClass("Main");
jmethodID method = env->GetStaticMethodID(mainClass, "setValue", "([B)V");

jbyteArray bytes = env->NewByteArray(7);
env->CallStaticVoidMethod(mainClass, method, bytes);
const char* str = (char*) env->GetByteArrayElements(bytes, 0);

printf(str);

//... use here

env->ReleaseByteArrayElements(bytes, (jbyte*) str, JNI_ABORT);