int main(int argc, char* argv[])
{
JNIEnv* env;
JavaVM* jvm;

env = create_vm(&jvm);

if (env == NULL) return 1;

jclass myClass = NULL;
jmethodID main = NULL;

/* Get the Hello World Class */
myClass = env->FindClass("HelloWorld");

/* Call the main method */
if (myClass != NULL)
    main = env->GetStaticMethodID(myClass, "main", "([Ljava/lang/String;)V");
else
    printf("Unable to find the requested class\n");


if (main != NULL)
{
   env->CallStaticVoidMethod( myClass, main, " ");
}else
   printf("main method not found") ;


jvm->DestroyJavaVM();
return 0;
}