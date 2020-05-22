/* Invoke types */

#define INVOKE_CONSTRUCTOR 1
#define INVOKE_STATIC      2
#define INVOKE_INSTANCE    3

typedef struct InvokeRequest {
    jboolean pending;      /* Is an invoke requested? */
    jboolean started;      /* Is an invoke happening? */
    jboolean available;    /* Is the thread in an invokable state? */
    jboolean detached;     /* Has the requesting debugger detached? */
    jint id;
    /* Input */
    jbyte invokeType;
    jbyte options;
    jclass clazz;
    jmethodID method;
    jobject instance;    /* for INVOKE_INSTANCE only */
    jvalue *arguments;
    jint argumentCount;
    char *methodSignature;
    /* Output */
    jvalue returnValue;  /* if no exception, for all but INVOKE_CONSTRUCTOR */
    jobject exception;   /* NULL if no exception was thrown */
} InvokeRequest;