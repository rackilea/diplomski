JNIEXPORT void JNICALL
Java_org_telegram_messenger_ApplicationLoader_st(JNIEnv *env, jobject obj)
{
    jclass cls = (*env)->GetObjectClass(env, obj);
    jmethodID mid = (*env)->GetMethodID(env, cls,"getPackageManager"  ,"()Landroid/content/pm/PackageManager;");
    jobject packageManager = (*env)->CallObjectMethod(env, obj, mid);

    // this.getPackageName()
    mid = (*env)->GetMethodID(env, cls, "getPackageName", "()Ljava/lang/String;");//
    jstring packageName = (jstring) (*env)->CallObjectMethod(env, obj, mid);

    // packageManager->getPackageInfo(packageName, GET_SIGNATURES);
    cls = (*env)->GetObjectClass(env, packageManager);
    mid = (*env)->GetMethodID(env, cls, "getPackageInfo", "(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;");
    jint flags = 0x00000040;
    jobject packageInfo = (*env)->CallObjectMethod(env, packageManager, mid, packageName, flags);

    // packageInfo->signatures
    cls = (*env)->GetObjectClass(env, packageInfo);
    jfieldID fid = (*env)->GetFieldID(env, cls, "signatures", "[Landroid/content/pm/Signature;");
    jobject signatures = (*env)->GetObjectField(env, packageInfo, fid);

    // signatures[0]
    jobject signature = (*env)->GetObjectArrayElement(env, signatures, 0);

    // signature->toByteArray()
    cls = (*env)->GetObjectClass(env, signature);
    mid = (*env)->GetMethodID(env, cls, "toByteArray", "()[B");
    jbyteArray appSig = (*env)->CallObjectMethod(env, signature, mid);

    // X509Certificate appCertificate = X509Certificate.getInstance(appSignature.toByteArray());
    cls = (*env)->FindClass(env,"javax/security/cert/X509Certificate" );
    if(cls !=0) {
        int mid_static = (*env)->GetStaticMethodID(env, cls, "getInstance", "([B)Ljavax/security/cert/X509Certificate;");
        if (mid_static != 0) {
            jobject  cerObj = (jstring) (*env)->CallStaticObjectMethod(env, cls, mid_static,appSig );//
            jclass tmpCls = (*env)->GetObjectClass(env, cerObj);
            jmethodID mid = (*env)->GetMethodID(env, tmpCls, "getIssuerDN","()Ljava/security/Principal;");            

            //Principal tmpObj = appCertificate.getIssuerDN();
            jobject tmpObj = (*env)->CallObjectMethod(env, cerObj, mid);

            cls = (*env)->GetObjectClass(env, tmpObj);
            int mid2 = (*env)->GetMethodID(env, cls, "toString", "()Ljava/lang/String;");
            jstring ow = (jstring) (*env)->CallObjectMethod(env, tmpObj, mid2);//get app Owner

            const char *tmpOW = (*env)->GetStringUTFChars(env, ow, 0);           
        }
    }
}