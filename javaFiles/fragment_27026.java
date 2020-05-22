//access field s in the object
jfieldID fid = (env)->GetFieldID(clazz, "s", "Ljava/lang/String;");
if (fid == NULL) {
    return; /* failed to find the field */
}

jstring jstr = (env)->GetObjectField(obj, fid);
jboolean iscopy;
const char *str = (env)->GetStringUTFChars(jstr, &iscopy);
if (str == NULL) {
    return; // usually this means out of memory
}

//use your string
...

(env)->ReleaseStringUTFChars(jstr, str);

...

//access integer field val in the object
jfieldID ifld = (env)->GetFieldID(clazz, "val", "I");
if (ifld == NULL) {
    return; /* failed to find the field */
}
jint ival = env->GetIntField(obj, ifld);
int value = (int)ival;