JNIEnv* create_vm(JavaVM ** jvm)
{
JNIEnv *env;
JavaVMInitArgs vm_args;
JavaVMOption options[2];

options[0].optionString = "-Djava.class.path=.";
options[1].optionString = "-DXcheck:jni:pedantic";  

vm_args.version = JNI_VERSION_1_6;
vm_args.nOptions = 2;
vm_args.options = options;
vm_args.ignoreUnrecognized = JNI_TRUE; // remove unrecognized options

int ret = JNI_CreateJavaVM(jvm, (void**) &env, &vm_args);
if (ret < 0) printf("\n<<<<< Unable to Launch JVM >>>>>\n");
return env;
 }