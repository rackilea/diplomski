ClassA a;

 //sendA function for classA similiar as below.

extern "C"
JNIEXPORT jint JNICALL
Java_<PATH_TO_FUNCTION>_sendB(JNIEnv *env,jobject instance,jobject BObj) {
    LOGD(TAG,"sendB: START");
    jclass jBClass=env->FindClass("com/< path to class separated by '/' >");

    //  int Field jbid

    jfieldID jbid = env->GetFieldID(jBClass, "bId", "I"); 
    jint bId = env->GetIntField(BObj, jbid);
    obja.objb[0].bId = (int) bId;
    LOGI(TAG, "\t bId[%d]: %d ", 0, obja.objb[0].bId); 
     return 0; 
   }