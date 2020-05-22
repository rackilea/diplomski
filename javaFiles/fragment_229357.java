%module test
%{
#include "test.h"
%}

%include <carrays.i>

%array_functions(signed char, ByteArray);

%apply SWIGTYPE* { const char *GetThings };

%pragma(java) moduleimports=%{
import java.util.ArrayList;
import java.io.ByteArrayOutputStream;
%}

%pragma(java) modulecode=%{
static private String[] pptr2array(long in, boolean owner) {
  SWIGTYPE_p_signed_char raw=null;
  try {
    raw = new SWIGTYPE_p_signed_char(in, owner);
    ArrayList<String> tmp = new ArrayList<String>();
    int pos = 0;
    ByteArrayOutputStream bos = new ByteArrayOutputStream();
    while (ByteArray_getitem(raw, pos) != 0) {
      byte c;
      while ((c = ByteArray_getitem(raw, pos++)) != 0) {
        bos.write(c);
      }
      tmp.add(bos.toString());
      bos.reset();
    }
    return tmp.toArray(new String[tmp.size()]);
  }
  finally {
    if (owner && null != raw) {
      delete_ByteArray(raw);
    }
  }
}
%}

%typemap(jstype) const char *GetThings "String[]";
%typemap(javaout) const char *GetThings {
  return pptr2array($jnicall, $owner);
}

%include "test.h"