%module method1

%{
#include "test.h"
%}

%inline %{
void setLogFile(const char *fn) {
  FILE *f = fopen(fn, "w");
  setLogFile(f);
}
%}