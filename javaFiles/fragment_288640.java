/**
 * The NativeActivity object handle.
 *
 * IMPORTANT NOTE: This member is mis-named. It should really be named 
 * 'activity' instead of 'clazz', since it's a reference to the
 * NativeActivity instance created by the system for you.
 * 
 * We unfortunately cannot change this without breaking NDK
 * source-compatibility.
*/
jobject clazz;