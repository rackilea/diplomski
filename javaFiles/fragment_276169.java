JNIEXPORT jobject JNICALL Java_org_smartcar_serverdatainterface_shared_services_CppConnector_getProjectionPoint
  (JNIEnv *env, jobject obj, jdouble lat, jdouble lon)
{
    jclass class = (*env)->FindClass(env,"org/smartcar/serverdatainterface/shared/businessentities/Node");

    if (NULL == class)
        PrintError ("class");

    jmethodID cid = (*env)->GetMethodID(env,class, "<init>", "(DD)V");

   if (NULL == cid)
       PrintError ("method");

   return (*env)->NewObject(env, class, cid, lat, lon);
}