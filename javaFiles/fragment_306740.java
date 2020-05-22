/* Class CLASS */
jclass Classcls = env->FindClass("java/lang/Class");


/* String CLASS */
jclass StringCls = env->FindClass("java/lang/String");

jstring methodString = env->NewStringUTF("de.domain.sayHello");

jclass myJavaClass = (jclass)env->CallObjectMethod(MyURLClassLoaderInstance, URLClassLoaderCLS_loadClass, methodString);