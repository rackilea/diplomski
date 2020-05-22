%module(directors="1") c_backend

%{
#include "c_backend.h"
#include <iostream>
%}

%feature("director") Person;
%feature("director") JobPool;
// Call our extra Java code to figure out if this was really a Java object to begin with
%typemap(javadirectorin) Person * "$jniinput == 0 ? null : new $*javaclassname($jniinput, false).swigFindRealImpl()"
// Pass jenv into our %extend code
%typemap(in,numinputs=0) JNIEnv *jenv "$1 = jenv;"
%extend Person {
    // return the underlying Java object if this is a Director, or null otherwise
    jobject swigOriginalObject(JNIEnv *jenv) {
        Swig::Director *dir = dynamic_cast<Swig::Director*>($self);
        std::cerr << "Dynamic_cast: " << dir << "\n";
        if (dir) {
            return dir->swig_get_self(jenv);
        }
        return NULL;
    }
}
%typemap(javacode) Person %{
  // check if the C++ code finds an object and just return ourselves if it doesn't
  public Person swigFindRealImpl() {
     Object o = swigOriginalObject();
     return o != null ? ($javaclassname)o : this; 
  }
%}
%include "c_backend.h"