void JavaInterface::init_methods()
{
    this->IDconstructor = this->JNIEnvironment->GetMethodID(this->javaClass, "<init>", "()V");
    if (this->IDconstructor == NULL) 
    {
        throw std::runtime_error("JAVA_INIT_METHOD_EXCEPTION");
    }

    this->IDsetInputXML = this->JNIEnvironment->GetStaticMethodID(this->javaClass, "setInputXML", "(Ljava/lang/String;)V");
    if (this->IDsetInputXML == NULL) 
    {
        throw std::runtime_error("JAVA_INIT_METHOD_EXCEPTION");
    }

    this->IDgetInputXML = this->JNIEnvironment->GetStaticMethodID(this->javaClass, "getInputXML", "()Ljava/lang/String;");
//} <- This brace must be further down
    if (this->IDgetInputXML == NULL) 
    {
        throw std::runtime_error("JAVA_INIT_METHOD_EXCEPTION");
    }
} // <- To here