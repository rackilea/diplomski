void JNICALL MethodTraceAgent::HandleMethodEntry(jvmtiEnv* jvmti, JNIEnv* jni, jthread thread, jmethodID method)
{
try {
    jvmtiError error;
    jclass clazz;
    char* name;
    char* signature;

    // get declaring class of the method
    error = m_jvmti->GetMethodDeclaringClass(method, &clazz); 
    Errors::Check(error);
    // get the signature of the class
    error = m_jvmti->GetClassSignature(clazz, &signature, 0);
    Errors::Check(error);
    // get method name
    error = m_jvmti->GetMethodName(method, &name, NULL, NULL);
    Errors::Check(error);

    char tmp[1024]; 
    sprintf(tmp, "%s%s", signature, name); 
    if(pFilter->Match("method", tmp)) { // intrested method?
        char out[1024];
        jint param_size = 0;

        error = m_jvmti->GetArgumentsSize(method, &param_size);
        int line_len = sprintf(out, "method_entry: %s%s%, param_size:%d", signature, name, param_size);             

        // visit local variable
        jint entry_count = 0;
        jvmtiLocalVariableEntry *table_ptr = NULL;      
        jlocation cur_loc;

        // this call may return JVMTI_ERROR_ABSENT_INFORMATION, this error is avoided by initialize entry_count to 0 to escape the following for loop
        error = m_jvmti->GetLocalVariableTable(method, &entry_count, &table_ptr);
        error = m_jvmti->GetFrameLocation(thread, 0, NULL, &cur_loc);
        for(int j=0; j<min(param_size, entry_count); j++) {
            if(table_ptr[j].start_location > cur_loc) break;
            if(table_ptr[j].signature[0] == 'L') { //   fully-qualified-class
                jobject param_obj;
                jlong param_obj_tag = 0; 

                error = m_jvmti->GetLocalObject(thread, 0, table_ptr[j].slot, &param_obj); // frame at depth zero is the current frame                  
                m_jvmti->GetTag(param_obj, &param_obj_tag);
                if(param_obj_tag == 0) {
                    m_jvmti->SetTag(param_obj, theTag);
                    param_obj_tag = theTag;
                    ++theTag;
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


        // put to log list
        logList.push_back(out);

        printf("\r%-10d", logList.size());
    }

    // release resources
    error = m_jvmti->Deallocate(reinterpret_cast<unsigned char*>(name));
    Errors::Check(error);
    error = m_jvmti->Deallocate(reinterpret_cast<unsigned char*>(signature));
    Errors::Check(error);

} catch (AgentException& e) {
    cout << "Error when enter HandleMethodEntry: " << e.what() << " [" << e.ErrCode() << "]" << endl;
}
}