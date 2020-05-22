// Create a native thread - java part
native void cFunction()
...
cFunction();

//  Create a native thread - C part
void *processing_function(void *p);
JNIEXPORT void JNICALL Java____cFunction(JNIEnv *e, jobject obj) {
    pthread_t t;
    pthread_create(&t, NULL, processing_function, NULL);    
}