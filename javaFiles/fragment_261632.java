static jclass    File;
static jmethodID FileCtor;

...

   if( File == NULL ) {
      File     = env->FindClass( "java/io/File" );
      FileCtor = env->GetMethodID( File, "<init>", "(Ljava/lang/String;)V");
   }