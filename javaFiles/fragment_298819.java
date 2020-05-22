static int getFd(JNIEnv *env, jobject sock)
{
    JNIEnv e = *env;
    jclass clazz;
    jfieldID fid;
    jobject impl;
    jobject fdesc;

    /* get the SocketImpl from the Socket */
    if (!(clazz = e->GetObjectClass(env,sock)) ||
        !(fid = e->GetFieldID(env,clazz,"impl","Ljava/net/SocketImpl;")) ||
        !(impl = e->GetObjectField(env,sock,fid))) return -1;

    /* get the FileDescriptor from the SocketImpl */
    if (!(clazz = e->GetObjectClass(env,impl)) ||
        !(fid = e->GetFieldID(env,clazz,"fd","Ljava/io/FileDescriptor;")) ||
        !(fdesc = e->GetObjectField(env,impl,fid))) return -1;

    /* get the fd from the FileDescriptor */
    if (!(clazz = e->GetObjectClass(env,fdesc)) ||
        !(fid = e->GetFieldID(env,clazz,"fd","I"))) return -1;

    /* return the descriptor */
    return e->GetIntField(env,fdesc,fid);
}