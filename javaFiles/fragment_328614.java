%module(directors="1") Test

%{
#include "test.hh"
%}

%pragma(java) jniclasscode=%{
  static {
    try {
        System.loadLibrary("test");
    } catch (UnsatisfiedLinkError e) {
      System.err.println("Native code library failed to load. \n" + e);
      System.exit(1);
    }
  }
%}

/* Pretty standard so far, loading the shared object 
   automatically, enabling directors and giving the module a name. */    

// An import for the hashmap type
%typemap(javaimports) GameObject %{
import java.util.HashMap;
import java.lang.ref.WeakReference;
%}

// Provide a static hashmap, 
// replace the constructor to add to it for derived Java types
%typemap(javabody) GameObject %{
  private static HashMap<Long, WeakReference<$javaclassname>> instances 
                        = new HashMap<Long, WeakReference<$javaclassname>>();

  private long swigCPtr;
  protected boolean swigCMemOwn;

  public $javaclassname(long cPtr, boolean cMemoryOwn) {
    swigCMemOwn = cMemoryOwn;
    swigCPtr = cPtr;
    // If derived add it.
    if (getClass() != $javaclassname.class) {
      instances.put(swigCPtr, new WeakReference<$javaclassname>(this));
    }
  }

  // Just the default one
  public static long getCPtr($javaclassname obj) {
    return (obj == null) ? 0 : obj.swigCPtr;
  }

  // Helper function that looks up given a pointer and 
  // either creates or returns it
  static $javaclassname createOrLookup(long arg) {
    if (instances.containsKey(arg)) {
      return instances.get(arg).get();
    }
    return new $javaclassname(arg,false);
  }
%}

// Remove from the map when we release the C++ memory
%typemap(javadestruct, methodname="delete", 
         methodmodifiers="public synchronized") GameObject {
  if (swigCPtr != 0) {
    // Unregister instance
    instances.remove(swigCPtr);
    if (swigCMemOwn) {
      swigCMemOwn = false;
      $imclassname.delete_GameObject(swigCPtr);
    }
    swigCPtr = 0;
  }
}

// Tell SWIG to use the createOrLookup function in director calls.
%typemap(javadirectorin) GameObject& %{
    $javaclassname.createOrLookup($jniinput)
%}
%feature("director") GameObject;

// Finally enable director for CollisionListener and include the header
%feature("director") CollisionListener;    
%include "test.hh"