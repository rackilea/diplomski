jmethodID myClassMethod;
myClassMethod = env->GetMethodID(myClass, "doIt","()Ljava/lang/String;");

if (myClassMethod == NULL) { 
    // Method of Class "de.domain.sayHello" not found
}