%module test

%javamethodmodifiers TestAnnotation::getMessage() %{
  @Nullable
  public%};

%typemap(jstype) char *message "@Nullable String";

%include "test.h"