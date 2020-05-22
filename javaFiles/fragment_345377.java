jint
readSingle(JNIEnv *env, jobject this, jfieldID fid) {
    jint nread;
    char ret;
    FD fd = GET_FD(this, fid);
    if (fd == -1) {
        JNU_ThrowIOException(env, "Stream Closed");
        return -1;
    }
    nread = (jint)IO_Read(fd, &ret, 1);
    if (nread == 0) { /* EOF */
        return -1;
    } else if (nread == JVM_IO_ERR) { /* error */
        JNU_ThrowIOExceptionWithLastError(env, "Read error");
    } else if (nread == JVM_IO_INTR) {
        JNU_ThrowByName(env, "java/io/InterruptedIOException", NULL);
    }
    return ret & 0xFF;
}