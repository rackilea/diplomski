//object that will hold all thread information.
struct ThreadParams
{
    JNIEnv* env;
    jobject runnable;
};

//function that the thread will call.
DWORD __stdcall RunnableThreadProc(void* ptr)
{
    ThreadParams* p = reinterpret_cast<ThreadParams*>(ptr); //get our thread info from the parameter.
    JNIEnv* env = p->env; //grab our env.
    jobject runnable = p->runnable; //grab our runnable object.
    delete p; //since we allocated on the heap using new, we must delete from the heap.
    //this is because c++ does not have garbage collection.

    jclass RunnableInterface = env->GetObjectClass(runnable); //get our java runnable interface instance.
    jmethodID Run = env->GetMethodID(RunnableInterface, "run","()V"); //get the run method function pointer.
    env->CallObjectMethod(RunnableInterface, Run); //call RunnableInterface.run();
}

JNIEXPORT void JNICALL Java_JNIExample_StartNativeThread(JNIEnv* env, jobject obj, jobject runnable)
{
    ThreadParams* ptr = new ThreadParams(); //create an object to store our parameters.
    ptr->env = env;  //store the env parameter.
    ptr->runnable = runnable; //store the runnable object.

    //create a thread that calls "RunnableThreadProc" and passes it "ptr" as a param.
    CreateThread(0, 0, RunnableThreadProc, reinterpret_cast<void*>(ptr), 0, 0); 
}