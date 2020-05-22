//c_backend.i
%module(directors="1") c_backend

%{
#include "c_backend.h"
%}

%feature("director") Person;
%feature("director") JobPool;
%typemap(jtype) Person * "Object"
%typemap(jnitype) Person * "jobject"
%typemap(javadirectorin) Person * "$jniinput instanceof $*javaclassname ? ($*javaclassname)$jniinput : new $*javaclassname((Long)$jniinput), false)"
%typemap(directorin,descriptor="L/java/lang/Object;") Person * {
    SwigDirector_$1_basetype *dir = dynamic_cast<SwigDirector_$1_basetype*>($1);
    if (!dir) {
        jclass cls = JCALL1(FindClass, jenv, "java/lang/Long");
        jmid ctor = JCALL3(GetMethodID, jenv, cls, "<init>", "J(V)");
        $input = JCALL3(NewObject, jenv, cls, ctor, reinterpret_cast<jlong>($1));
    }
    else {
        $input = dir->swig_get_self(jenv);
    }
}
%include "c_backend.h"