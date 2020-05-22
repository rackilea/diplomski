%module test
%{
#include "test.h"
%}

%rename(GetThings) GetThings_Wrapper;
%immutable;
%inline %{
  typedef struct {
    const char *str;
  } StrArrHandle;

  StrArrHandle GetThings_Wrapper() {
    const StrArrHandle ret = {GetThings()};
    return ret;
  }
%}
%extend StrArrHandle {
  const char *next() {
    const char *ret = $self->str;
    if (*ret)
      $self->str += strlen(ret)+1;
    else
      ret = NULL;
    return ret;
  }
}

%ignore GetThings;
%include "test.h"