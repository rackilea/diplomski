char** convert(JNIEnv *env, jobjectArray jstringArray, int n_threads)
{

    int n_rows =(*env)->GetArrayLength(env, jstringArray);
    char **cArray = (char **) malloc(n_rows * sizeof(char*));
    int i=0;
    jstring row;

    JavaVM* jvm = NULL;
    JNIEnv *thr_env;

    ( *env )->GetJavaVM( env, &jvm );

    if(n_threads <= 0 ) n_threads = 1;
    #pragma omp parallel num_threads(n_threads)  private( thr_env )
    {
        // attach this thread to the JVM
        ( *jvm )->AttachCurrentThread( jvm, ( void** ) &thr_env, NULL );
        // run the for loop
        #pragma omp for private(i, row)
        for (i=0; i<n_rows; i++)
        {
             row = (jstring)
                 (*env)->GetObjectArrayElement(env, jstringArray, i);
             cArray[i] = (char*)(*env)->GetStringUTFChars(env, row, 0);
             printf(
                 "cArray[%d]: %s thread:%d row:%p env:%p jstringArray:%p\n",
                 i, cArray[i], omp_get_thread_num(), row, env, jstringArray);
        }
        ( *jvm )->DetachCurrentThread( jvm );
    }

    return cArray;
}