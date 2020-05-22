/* load and initialize a Java VM, return a JNI interface  
* pointer in env */ 
JNI_CreateJavaVM(&jvm, &env, &vm_args); 

/* invoke the Main.test method using the JNI */ 
jclass cls = env->FindClass("Main"); 
jmethodID mid = env->GetStaticMethodID(cls, "test", "(I)V"); 
env->CallStaticVoidMethod(cls, mid, 100);