void JNICALL
Class_File_Load_Hook(jvmtiEnv *jvmti_env,
            JNIEnv* jni_env,
            jclass class_being_redefined,
            jobject loader,
            const char* name,
            jobject protection_domain,
            jint class_data_len,
            const unsigned char* class_data,
            jint* new_class_data_len,
            unsigned char** new_class_data)
{
    jvmtiError err;
    unsigned char* jvmti_space = NULL;
    char* args = "vop";

    javab_main(3, args, class_data, class_data_len);

    err = (*jvmti_env)->Allocate(jvmti_env, (jlong)global_pos, &jvmti_space);
    check_jvmti_error(jvmti_env, err, "Allocate new class Buffer.");

    (void)memcpy((void*)jvmti_space, (void*)new_class_ptr, (int)global_pos);

    *new_class_data_len = (jint)global_pos;
    *new_class_data = jvmti_space;
}