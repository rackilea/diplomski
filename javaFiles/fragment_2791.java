void println(JNIEnv *jep, byte *format,...) {
    va_list                             vap;
    byte                                txt[5001];
    jsize                               txtlen;
    jclass                              eCls;
    jint                                mId;
    jbyteArray                          jText;

    va_start(vap,format); vsprintf(txt,format,vap); va_end(vap);
    txtlen=(long)strlen(txt);

    if((eCls=(*jep)->FindClass(jep,"<your/package/here/JNIGlobal"))==0) {
        printf("JNI: Global class not found (Error Text: %s)\n",txt);
        return; /* give up */
        }
    if((mId=(*jep)->GetStaticMethodID(jep,eCls,"println","(Ljava/lang/Object;)V"))==0) {
        printf("JNI: Global println method not found (Error Text: %s)\n",txt);
        return; /* give up */
        }
    jText=(*jep)->NewByteArray(jep,txtlen);
    (*jep)->SetByteArrayRegion(jep,jText,0,txtlen,(void*)txt);
    (*jep)->CallStaticVoidMethod(jep,eCls,mId,jText);
    }