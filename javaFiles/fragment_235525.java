void invoke_class(JNIEnv* env) {
  jclass helloWorldClass;
  jmethodID mainMethod;
  jobjectArray applicationArgs;
  jstring applicationArg0;

  helloWorldClass = (env)->FindClass("InvocationHelloWorld");
  if(! helloWorldClass )
  {
    std::cerr<<"Couldn't get \"InvocationHelloWorld\""<<std::endl;
    return;
  }

  mainMethod = (env)->GetStaticMethodID(helloWorldClass, "main", "([Ljava/lang/String;)V");
  if(! mainMethod )
  {
    std::cerr<<"Coulnd't get \"InvocationHelloWorld::main\""<<std::endl;
    return;
  }

  applicationArgs = (env)->NewObjectArray(1, (env)->FindClass("java/lang/String"), NULL);
  applicationArg0 = (env)->NewStringUTF("From-C-program");
  (env)->SetObjectArrayElement(applicationArgs, 0, applicationArg0);

  (env)->CallStaticVoidMethod(helloWorldClass, mainMethod, applicationArgs);
}