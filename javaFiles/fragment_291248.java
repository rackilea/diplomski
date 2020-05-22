JNIEXPORT jlong JNICALL some_class_getClassInstance(
    JNIenv *env, jclass cl )
{
    myClass *cls = new MyClass();
    return( ( jlong )( intptr_t ) cls );
}

JNIEXPORT jlong JNICALL some_class_getClassInstance(
    JNIenv *env, jclass cl, jlong file )
{
    FILE *fp = ( FILE * )( intptr_t ) file;
    myClass *cls = new MyClass( fp );
    return( ( jlong )( intptr_t ) cls );
}

JNIEXPORT jlong JNICALL some_class_getFileFromClass(
    JNIenv *env, jclass cl, jlong cls )
{
    myClass *instance = ( myClass * )( intptr_t ) cls;

    FILE *fp = myClass->getFile();

    return( ( jlong )( intptr_t ) fp );
}

JNIEXPORT void JNICALL some_class_name_closeFile(
    JNIenv *env, jclass cls, jlong file )
{
    FILE *fp = ( FILE * ) ( intptr_t ) file;
    fclose( fp );
}