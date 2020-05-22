%module test

%typemap(jni) signed char *content "jbyteArray"
%typemap(jtype) signed char *content "byte[]"
%typemap(jstype) signed char *content "byte[]"
%typemap(javaout) signed char *content {
    return $jnicall;
}

%typemap(out) signed char * content {
    $result = JCALL1(NewByteArray, jenv, arg1->contentLength);
    JCALL4(SetByteArrayRegion, jenv, $result, 0, arg1->contentLength, $1);
}

// Optional: ignore contentLength;
%ignore contentLength;

%inline %{
typedef struct {
    signed char * content;
    int contentLength;
} Foo;
%}