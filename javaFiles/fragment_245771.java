%module test

%{
#include <assert.h>
%}

%typemap(in,numinputs=0) (DataStruct **ppdata, size_t *psize) (size_t tempsize, DataStruct *tempdata) %{
  $2 = &tempsize;
  $1 = &tempdata;
%}

%typemap(jtype) int get_all_data "long[]";
%typemap(jstype) int get_all_data "DataStruct[]";
%typemap(javaout) int get_all_data {
    final long[] arr = $jnicall;
    DataStruct[] ret = new DataStruct[arr.length];
    for (int i = 0; i < arr.length; ++i) {
      ret[i] = new DataStruct(arr[i], false);
    }
    return ret;
  }

%typemap(jni) int get_all_data "jlongArray";

%typemap(out) int get_all_data %{
  // Handle errors in the int return value ($1)
  assert(!$1);
%}

%typemap(argout) (DataStruct **ppdata, size_t *psize) {
  $result = JCALL1(NewLongArray, jenv, *$2);
  jlong temparr[*$2];
  for (size_t i = 0; i < *$2; ++i) {
    *(DataStruct**)&temparr[i] = &((*$1)[i]);
  }
  JCALL4(SetLongArrayRegion, jenv, $result, 0, *$2, temparr);
}

%inline %{
typedef struct {
    int id;
    double x;
    double y;
} DataStruct;

int get_all_data ( long ref, DataStruct **ppdata, size_t *psize ) {
    static const size_t size = 4;
    *ppdata = (DataStruct*) malloc(sizeof(DataStruct) * size);
    *psize = size;
    for (size_t  i = 0; i < size; ++i) {
      DataStruct val = {i,i,i};
      (*ppdata)[i] = val;
    }
    return 0;
}
%}