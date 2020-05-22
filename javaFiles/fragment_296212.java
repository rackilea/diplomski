%module Rec
%include "various.i"

%typemap(jni)     char **db = char **STRING_ARRAY;
%typemap(jtype)   char **db = char **STRING_ARRAY;
%typemap(jstype)  char **db = char **STRING_ARRAY;
%typemap(in)      char **db = char **STRING_ARRAY;
%typemap(freearg) char **db = char **STRING_ARRAY;
%typemap(javain)  char **db = char **STRING_ARRAY;

%include "sab1.hpp"