jclass matClass = static_cast<jclass>(env->FindClass("com/example/Mat");
jmethodID matConstructor = env->GetMethodID(matClass, "<init>", "([I)V");
for (int index=0; index<50; index++)
{
    jobject jMatObject = env->NewObject(matClass, matConstructor, des_object[index]);
    env->SetObjectArrayElement( arr, i, jMatObject);
    env->DeleteLocalRef(jMatObject);
}