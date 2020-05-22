/* turn this module into java using SWIG */
%module er_java

%{
    #include <vector>
    #include <complex>
    #include "read_data.hh"
    #include "do_something_with_data.hh"
%}

/* Let's just grab the original header file here */
%include "std_vector.i"
%include "std_string.i"

namespace std {
    %template(vector_complex_float) vector<complex<float> >;
    %template(vector_float) vector<float>;
}    

/* boilerplate code */
%pragma(java) jniclasscode=%{
  static {
    try {
      java.lang.System.loadLibrary("read_data");
      java.lang.System.loadLibrary("do_something_with_data");
    } catch (UnsatisfiedLinkError e) {
      java.lang.System.err.println("Native code library failed to import");
      java.lang.System.exit(1);
    }
  }
%}

%include "read_data/read_data.hh"
%include "do_something_with_data/do_something_with_data.hh"