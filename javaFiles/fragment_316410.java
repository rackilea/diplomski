%module(directors="1") test

%{
#include "test.h"
#include <assert.h>
#include <ffi.h>
%}

%feature("director") Callback;

// This rename makes getting the C++ generation right slightly simpler
%rename(Log) Callback::call;

// Make it abstract
%javamethodmodifiers Callback::call "public abstract"
%typemap(javaout) void Callback::call ";"
%typemap(javaclassmodifiers) Callback "public abstract class"
%typemap(jstype) Callback_t "Callback";
%typemap(jtype) Callback_t "long";
%typemap(jni) Callback_t "jlong";
%typemap(javain) Callback_t "$javainput.prepare_fp()";
%typemap(in) Callback_t {
  $1 = (Callback_t)$input;
}

%inline %{
struct Callback {
  virtual void call(Log l, const char *s) = 0;
  virtual ~Callback() {
    if (bound_fn) ffi_closure_free(closure);
  }

  jlong prepare_fp() {
    if (!bound_fn) {
      int ret;
      args[0] = &ffi_type_uint;
      args[1] = &ffi_type_pointer;
      closure = static_cast<decltype(closure)>(ffi_closure_alloc(sizeof(ffi_closure), &bound_fn));
      assert(closure);
      ret=ffi_prep_cif(&cif, FFI_DEFAULT_ABI, 2, &ffi_type_void, args);
      assert(ret == FFI_OK);
      ret=ffi_prep_closure_loc(closure, &cif, java_callback, this, bound_fn);
      assert(ret == FFI_OK);
    }
    return *((jlong*)&bound_fn);
  }
private:
  ffi_closure *closure;
  ffi_cif cif;
  ffi_type *args[2];
  void *bound_fn;

  static void java_callback(ffi_cif *cif, void *ret, void *args[], void *userdata) {
    (void)cif;
    (void)ret;
    Callback *cb = static_cast<Callback*>(userdata);
    printf("Starting arg parse\n");
    Log l = (Log)*(unsigned*)args[0];
    const char *s = *(const char**)args[1];
    printf("In java_callback: %s\n", s);
    cb->call(l, s);
  }
};
%}

%include "test.h"