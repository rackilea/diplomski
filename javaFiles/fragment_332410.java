int xy[2]={4,5};

...

jintArray jxy = env->NewIntArray(2);
env->SetIntArrayRegion(jxy, 0, 2, xy);
constructor = env->GetMethodID(cls, "<init>", "([I)V");
jobject obj = env->NewObject(cls, constructor,  jxy);