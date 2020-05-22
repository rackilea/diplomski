%module test 

%{
#include "test.h"
#include <assert.h>
#include <ffi.h>

struct Callback {
  ffi_closure *closure;
  ffi_cif cif;
  ffi_type *args[2];
  JavaVM *jvm;
  void *bound_fn;
  jobject obj;
};

static void java_callback(ffi_cif *cif, void *ret, void *args[], struct Callback *cb) {
  printf("Starting arg parse\n");
  Log l = *(unsigned*)args[0];
  const char *s = *(const char**)args[1];
  assert(cb->obj);
  printf("In java_callback: %s\n", s);
  JNIEnv *jenv = 0;
  assert(cb);
  assert(cb->jvm);
  const int result = (*cb->jvm)->GetEnv(cb->jvm, (void**)&jenv, JNI_VERSION_1_6);
  assert(JNI_OK == result);
  const jclass cbintf = (*jenv)->FindClass(jenv, "Callback");
  assert(cbintf);
  const jmethodID cbmeth = (*jenv)->GetMethodID(jenv, cbintf, "Log", "(LLog;Ljava/lang/String;)V");
  assert(cbmeth);
  const jclass lgclass = (*jenv)->FindClass(jenv, "Log");
  assert(lgclass);
  const jmethodID lgmeth = (*jenv)->GetStaticMethodID(jenv, lgclass, "swigToEnum", "(I)LLog;");
  assert(lgmeth);
  jobject log = (*jenv)->CallStaticObjectMethod(jenv, lgclass, lgmeth, (jint)l);
  assert(log);
  (*jenv)->CallVoidMethod(jenv, cb->obj, cbmeth, log, (*jenv)->NewStringUTF(jenv, s));
}

%}

// 3:
%typemap(jstype) Callback_t "Callback";
%typemap(jtype) Callback_t "long";
%typemap(jni) Callback_t "jlong";
%typemap(javain) Callback_t "$javainput.prepare_fp($javainput)";

// 4:
%typemap(in) Callback_t {
  $1 = (Callback_t)$input;
}

%typemap(javaclassmodifiers) struct Callback "public abstract class"
%typemap(javacode) struct Callback %{
  public abstract void Log(Log l, String s);
%}

%typemap(in,numinputs=1) (jobject me, JavaVM *jvm) {
  $1 = JCALL1(NewWeakGlobalRef, jenv, $input);
  JCALL1(GetJavaVM, jenv, &$2);
}

struct Callback {
  %extend {
    jlong prepare_fp(jobject me, JavaVM *jvm) {
      if (!$self->bound_fn) {
        int ret;
        $self->args[0] = &ffi_type_uint;
        $self->args[1] = &ffi_type_pointer;
        $self->closure = ffi_closure_alloc(sizeof(ffi_closure), &$self->bound_fn);
        assert($self->closure);
        ret=ffi_prep_cif(&$self->cif, FFI_DEFAULT_ABI, 2, &ffi_type_void, $self->args);
        assert(ret == FFI_OK);
        ret=ffi_prep_closure_loc($self->closure, &$self->cif, java_callback, $self, $self->bound_fn);
        assert(ret == FFI_OK);
        $self->obj = me;
        $self->jvm = jvm;
      }
      return *((jlong*)&$self->bound_fn);
    }
    ~Callback() {
      if ($self->bound_fn) {
        ffi_closure_free($self->closure);
      }
      free($self);
    }
  }
};

%include "test.h"