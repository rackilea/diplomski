jmethodID method = env->GetStaticMethodID(mainClass, "setValue", "(Ljava/nio/ByteBuffer;)V");

const int buff_size = 1024;
char buff[buff_size]; // Creating a view over this block of memory
env->CallStaticVoidMethod(mainClass, method, env->NewDirectByteBuffer(buff, buff_size));
//... use buff