JNIEXPORT void JNICALL Java_Main_readRam
    (JNIEnv *env, jclass, jobject byteBuffer, jlong addr jint pid) {

    struct iovec local[1];
    struct iovec remote[1];

    void* buf = env->GetDirectBufferAddress(byteBuffer);
    jlong len = env->GetDirectBufferCapacity(byteBuffer);

    local[0].iov_base = buf;
    local[0].iov_len = len;

    remote[0].iov_base = (void *) addr;
    remote[0].iov_len = len;

    process_vm_readv(pid, local, 1, remote, 1, 0);
}