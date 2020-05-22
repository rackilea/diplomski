// Connect to an existing jvm
jint vm = JNI_GetCreatedJavaVMs(...

// Find the class
jclass cls = env->FindClass("your/namespace/Class");

// Get the method
jmethodID m = env->GetMethodID(clsm, "methodToInvoke", "()V");

// Call the method on the object
jobject res = env->CallObjectMethod(objInstance, m);