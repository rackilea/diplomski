%module test 

%{
#include "test.h"
#include <assert.h>

// NEW: global variables (bleurgh!)
static jobject obj;
static JavaVM *jvm;

// 2:
static void java_callback(Log l, const char *s) {
  printf("In java_callback: %s\n", s);
  JNIEnv *jenv = 0;
  // NEW: might as well call GetEnv properly...
  const int result = (*jvm)->GetEnv(jvm, (void**)&jenv, JNI_VERSION_1_6);
  assert(JNI_OK == result);
  const jclass cbintf = (*jenv)->FindClass(jenv, "Callback");
  assert(cbintf);
  const jmethodID cbmeth = (*jenv)->GetMethodID(jenv, cbintf, "Log", "(LLog;Ljava/lang/String;)V");
  assert(cbmeth);
  const jclass lgclass = (*jenv)->FindClass(jenv, "Log");
  assert(lgclass);
  const jmethodID lgmeth = (*jenv)->GetStaticMethodID(jenv, lgclass, "swigToEnum", "(I)LLog;");
  assert(lgmeth);
  jobject log = (*jenv)->CallStaticObjectMethod(jenv, lgclass, lgmeth, (jint)l);
  assert(log);
  (*jenv)->CallVoidMethod(jenv, obj, cbmeth, log, (*jenv)->NewStringUTF(jenv, s));
}

%}

// 3:
%typemap(jstype) Callback_t "Callback";
%typemap(jtype) Callback_t "Callback";
%typemap(jni) Callback_t "jobject";
%typemap(javain) Callback_t "$javainput";

// 4: (modified, not a multiarg typemap now)
%typemap(in) Callback_t {
  JCALL1(GetJavaVM, jenv, &jvm);
  obj = JCALL1(NewGlobalRef, jenv, $input);
  JCALL1(DeleteLocalRef, jenv, $input);
  $1 = java_callback;
}

%include "test.h"