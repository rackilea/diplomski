int xy[2]={4,5};

...

constructor = env->GetMethodID( cls, "<init>", "([I)V");
jobject obj = env->NewObject(cls, constructor,  xy);