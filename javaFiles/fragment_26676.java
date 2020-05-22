void JNICALL MethodTraceAgent::MTRACE_native_entry(JNIEnv *jni, jclass klass, jthread thread, jint cnum, jint mnum)
{

/* It's possible we get here right after VmDeath event, be careful */
if ( !pTheAgent->vmInitialized || pTheAgent->vmDead || thread == NULL)
    return;


jvmtiError error;
char out[1024];
int line_len = 0;
jvmtiFrameInfo frames[3];
jint cframe;

error = m_jvmti->GetStackTrace(thread, 0, 3, frames, &cframe);
Errors::Check(error);

if(cframe < 3) 
    return;

jmethodID method = frames[2].method;
jclass dec_cls;
char *mtd_name, *dec_cls_sig;

m_jvmti->GetMethodDeclaringClass(method, &dec_cls);
m_jvmti->GetClassSignature(dec_cls, &dec_cls_sig, NULL);
m_jvmti->GetMethodName(method, &mtd_name, NULL, NULL);


jboolean isNative = false;
m_jvmti->IsMethodNative(method, &isNative);
if(isNative)
    return;

line_len += sprintf(out + line_len, "m_en: %s%s", dec_cls_sig, mtd_name);

// operate tags
jint param_size = 0;
jint entry_count = 0;
jvmtiLocalVariableEntry *table_ptr = NULL;      

error = m_jvmti->GetArgumentsSize(method, &param_size);
error = m_jvmti->GetLocalVariableTable(method, &entry_count, &table_ptr);
Errors::Check(error);

line_len += sprintf(out + line_len, ", %d, %d", param_size, entry_count);

for(int j=0; j<min(param_size, entry_count); j++) {
    jobject param_obj = 0;

    if(j==0 && strcmp(table_ptr[0].name, "this") == 0) { // this instance
        error = m_jvmti->GetLocalInstance(thread, 2, &param_obj);
        if(thiso == 0) thiso = param_obj;
        else {
            line_len += sprintf(out + line_len, ", same_this: %d", jni->IsSameObject(thiso, param_obj));
        }

        jfieldID field = jni->GetFieldID(dec_cls, "a", "I");
        jint a = jni->GetIntField(param_obj, field);
        line_len += sprintf(out + line_len, ", a: %d", a);

        Errors::Check(error);
    }
    else if(table_ptr[j].signature[0] == 'L') { // object
        error = m_jvmti->GetLocalObject(thread, 2, table_ptr[j].slot, &param_obj); // frame at depth zero is the current frame      
        Errors::Check(error);
    }

    if(param_obj != 0) {

        //line_len += sprintf(out + line_len, ", modi: %d, this: %d, same: %d", modied, param_obj, jni->IsSameObject(param_obj, modied));

        jlong param_obj_tag = 0; 
        m_jvmti->GetTag(param_obj, &param_obj_tag);
        if(param_obj_tag == 0) {
            error = m_jvmti->SetTag(param_obj, pTheAgent->ctag);
            Errors::Check(error);
            param_obj_tag = pTheAgent->ctag;
            ++pTheAgent->ctag;
        }
        line_len += sprintf(out + line_len, ", param_obj_tag: %ld", param_obj_tag);
        //line_len += sprintf(out+line_len, ", slot:%d, start:%ld, cur:%ld, param:%s%s", table_ptr[j].slot, table_ptr[j].start_location, cur_loc, table_ptr[j].signature, table_ptr[j].name);

        jni->DeleteLocalRef(param_obj);
        m_jvmti->Deallocate(reinterpret_cast<unsigned char*>(table_ptr[j].signature));
        m_jvmti->Deallocate(reinterpret_cast<unsigned char*>(table_ptr[j].name));
        m_jvmti->Deallocate(reinterpret_cast<unsigned char*>(table_ptr[j].generic_signature));
    }

}

error = m_jvmti->Deallocate(reinterpret_cast<unsigned char*>(table_ptr));
Errors::Check(error);


m_jvmti->Deallocate(reinterpret_cast<unsigned char*>(dec_cls_sig));
m_jvmti->Deallocate(reinterpret_cast<unsigned char*>(mtd_name));



logList.push_back(out);

}