JNIEXPORT void JNICALL Java_de_domain_sayHello_sayHi
(JNIEnv *localEnv, jclass clazz, jstring message, jint times)
{

    int myT = times;

    for(int i=0;i<myT;i++)
        fprintf(stderr,"%s\n", localEnv->GetStringUTFChars(message, NULL));

}