%module test
%{
#include "test.h"
#include <assert.h>
%}

%typemap(jni) const char *GetThings "jobjectArray";
%typemap(jtype) const char *GetThings "String[]";
%typemap(jstype) const char *GetThings "String[]";
%typemap(javaout) const char *GetThings {
  return $jnicall;
}
%typemap(out) const char *GetThings {
  size_t count = 0;
  const char *pos = $1;
  while (*pos) {
    while (*pos++); // SKIP
    ++count;
  }
  $result = JCALL3(NewObjectArray, jenv, count, JCALL1(FindClass, jenv, "java/lang/String"), NULL);
  pos = $1;
  size_t idx = 0;
  while (*pos) {
    jobject str = JCALL1(NewStringUTF, jenv, pos);
    assert(idx<count);
    JCALL3(SetObjectArrayElement, jenv, $result, idx++, str);
    while (*pos++); // SKIP
  }
  //free($1); // Iff you need to free the C function's return value
}

%include "test.h"