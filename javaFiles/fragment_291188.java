%module method3

%{
#include "test.h"
#include <cassert>
%}

// 3:
%typemap(jni) FILE *fd "jobject"
// 1:
%typemap(jstype) FILE *fd "java.io.FileOutputStream"
// 2:
%typemap(jtype) FILE *fd "java.io.FileDescriptor"
// 4:
%typemap(in) (FILE *fd) {
  jfieldID field_fd;
  jclass class_fdesc;
  int rawfd;
  class_fdesc = jenv->FindClass("java/io/FileDescriptor");
  assert(class_fdesc);
  field_fd = jenv->GetFieldID(class_fdesc, "fd", "I");
  assert(field_fd);
  rawfd = jenv->GetIntField($input, field_fd);
  $1 = fdopen(rawfd, "w");
  // Add some code to throw a Java exception if $1 is NULL (i.e. error)
}
// 5: 
%typemap(javain, pre="    retainFD = $javainput;",
         throws="java.io.IOException") FILE *fd "$javainput.getFD()"
// 6:
%pragma(java) modulecode=%{
  private static java.io.FileOutputStream retainFD;
%}

%include "test.h"