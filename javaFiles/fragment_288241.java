jobjectArray stringArray;
jString tmp;
char *stringA = "Test1";
char *stringB = "Test2";
jclass clsString; 
jint size = 2;

clsString = (*env)->FindClass(env, "java/lang/String");
stringArray = (*env)->NewObjectArray(env, size, clsString, 0);

tmp = (*env)->NewStringUTF(env, stringB);
(*env)->SetObjectArrayElement(env, stringArray, 0, tmp);

tmp = (*env)->NewStringUTF(env, stringA);
(*env)->SetObjectArrayElement(env, stringArray, 1, tmp);

obj = (*env)->NewObject(env, jClass, MID_init, stringArray);