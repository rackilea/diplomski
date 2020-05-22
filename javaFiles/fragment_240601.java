%module test

%{
#include "header.h"
%}

%inline %{
  %immutable;
  struct FieldFetch {
    int status;
    int type;
    char *value;
  };
  %mutable;

  struct FieldFetch gaiaTextReaderFetchField(gaiaTextReaderPtr reader, int field_num) {
    struct FieldFetch result;
    result.status = gaiaTextReaderFetchField(reader, field_num, &result.type, &result.value);
    return result;
  }
%}

%ignore gaiaTextReaderFetchField;
%include "header.h"