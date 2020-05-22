JNIEnv * env;
jclass loadedJavaClass;
jmethodID loadedJavaMethod;

//assume JVM, class, and method are already loaded at this point.

//Get c string from std::string object pointer
const char * c_string = ((std::string*) pPin->GetUserData())->c_str();

//Create jstring from string
jstring stuff = env->NewStringUTF( c_string );

//pass jstring to Java function
env->CallStaticVoidMethod( loadedJavaClass, loadedJavaMethod, stuff );

//remove local reference to jstring
JavaEnvironment::getEnvironment()->DeleteLocalRef(stuff);