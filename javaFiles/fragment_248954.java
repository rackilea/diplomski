%typemap(javabody) SWIGTYPE %{
  private long swigCPtr;

  protected $javaclassname(long cPtr) {
    swigCPtr = cPtr;
  }
%}

%typemap(jtype, nopgcpp="1") SWIGTYPE * "long"
%typemap(javaout) SWIGTYPE {
    long cPtr = $jnicall;
    return new $javaclassname(cPtr);
  }

%typemap(javaout) SWIGTYPE *, SWIGTYPE [], SWIGTYPE (CLASS::*) {
    long cPtr = $jnicall;
    return (cPtr == 0) ? null : new $javaclassname(cPtr);
  }

%typemap(out) SWIGTYPE %{
  *($&1_ltype*)&$result = &$1;
%}

%typemap(javadestruct) SWIGTYPE ""

%typemap(javaclassmodifiers) SWIGTYPE "public final class"
%nodefaultctor;
%nodefaultdtor;
%immutable;