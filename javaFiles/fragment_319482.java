jint throwNoClassDefError( JNIEnv *env, char *message )
{
    jclass exClass;
    char *className = "java/lang/NoClassDefFoundError";

    exClass = (*env)->FindClass( env, className);
    if (exClass == NULL) {
        return throwNoClassDefError( env, className );
    }

    return (*env)->ThrowNew( env, exClass, message );
}

jint throwNoSuchMethodError(
        JNIEnv *env, char *className, char *methodName, char *signature )
{

    jclass exClass;
    char *exClassName = "java/lang/NoSuchMethodError" ;
    LPTSTR msgBuf;
    jint retCode;
    size_t nMallocSize;

    exClass = (*env)->FindClass( env, exClassName );
    if ( exClass == NULL ) {
        return throwNoClassDefError( env, exClassName );
    }

    nMallocSize = strlen(className) 
            + strlen(methodName)
            + strlen(signature) + 8;

    msgBuf = malloc( nMallocSize );
    if ( msgBuf == NULL ) {
        return throwOutOfMemoryError
                ( env, "throwNoSuchMethodError: allocating msgBuf" );
    }
    memset( msgBuf, 0, nMallocSize );

    strcpy( msgBuf, className );
    strcat( msgBuf, "." );
    strcat( msgBuf, methodName );
    strcat( msgBuf, "." );
    strcat( msgBuf, signature );

    retCode = (*env)->ThrowNew( env, exClass, msgBuf );
    free ( msgBuf );
    return retCode;
}

jint throwNoSuchFieldError( JNIEnv *env, char *message )
{
    jclass exClass;
    char *className = "java/lang/NoSuchFieldError" ;

    exClass = (*env)->FindClass( env, className );
    if ( exClass == NULL ) {
        return throwNoClassDefError( env, className );
    }

    return (*env)->ThrowNew( env, exClass, message );
}

jint throwOutOfMemoryError( JNIEnv *env, char *message )
{
    jclass exClass;
    char *className = "java/lang/OutOfMemoryError" ;

    exClass = (*env)->FindClass( env, className );
    if ( exClass == NULL ) {
        return throwNoClassDefError( env, className );
    }

    return (*env)->ThrowNew( env, exClass, message );
}