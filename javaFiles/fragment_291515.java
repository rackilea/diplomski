// Foo.java
public class Foo {

  private long foo_ptr;

  public Foo(String bar) {
    // Create internal foo with bar.
    this.foo_ptr = this.foo_new(bar)
  }

  protected void finalize() {
    // Delete internal foo.
    this.foo_delete(this.foo_ptr);
  }

  public String getBar() {
    // Return a copy of bar.
    return this.foo_bar(this.foo_ptr);
  }

  static {
    System.loadLibrary("javafoo");
  }

  private native long foo_new(String bar);
  private native void foo_delete(long foo_ptr);
  private native String foo_bar(long foo);
}

// javafoo.c
#include <jni.h>
#include "foo.h"

JNIEXPORT jlong JNICALL Java_Foo_foo_new(JNIEnv * env, jstring jbar) {
  // Convert java string to c string.
  char * bar = (*env)->GetStringUTFChars(env, jbar, NULL);
  if (bar == NULL) {
    return 0;
  }
  // Create internal foo with bar.
  foo * self = foo_new(bar);
  if (self == NULL) {
    (*env)->ReleaseStringUTFChars(env, jbar, bar);
    return 0;
  }
  // Delete bar c string.
  (*env)->ReleaseStringUTFChars(env, jbar, bar);
  // Return foo pointer as long.
  return (jlong)self;
}

JNIEXPORT void JNICALL Java_Foo_foo_delete(JNIEnv * env, jlong foo_ptr) {
  // Convert foo pointer from long.
  foo * self = (foo *)foo_ptr;
  // Delete internal foo.
  foo_delete(self);
}

JNIEXPORT jstring JNICALL Java_Foo_foo_bar(JNIEnv * env, jlong foo_ptr) {
  // Convert foo pointer from long.
  foo * self = (foo *)foo_ptr;
  // Create java string from bar c string.
  jstring jbar = (*env)->NewStringUTF(env, self->bar);
  // Return bar java string.
  return jbar;
}