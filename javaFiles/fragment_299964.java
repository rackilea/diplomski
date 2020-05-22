jclass jc_build = (*env)->FindClass(env, "android/os/Build" ); // Build class
jfieldID jfid_kMODEL = (*env)->GetStaticFieldID(env, jc_build, "MODEL", "Ljava/lang/String;"); // MODEL attr.

jstring js_model_value = (*env)->GetStaticObjectField(env, obj, jfid_kMODEL); // MODEL attr. value.
jstring js_glass_value = (*env)->NewStringUTF(env, "Glass"); // Glass string value.

const char * nat_model_value = (*env)->GetStringUTFChars( env, js_model_value, NULL ) ;
const char * nat_glass_value = (*env)->GetStringUTFChars( env, js_glass_value, NULL ) ;

if (strcmp(nat_model_value, nat_glass_value) == 0){
    // Both strings are equal
}