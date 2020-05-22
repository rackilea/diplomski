JVM_ENTRY(void, JVM_ArrayCopy(JNIEnv *env, jclass ignored, jobject src, jint src_pos, 
                               jobject dst, jint dst_pos, jint length))  
  JVMWrapper("JVM_ArrayCopy");
  // Check if we have null pointers
  if (src == NULL || dst == NULL) {
    THROW(vmSymbols::java_lang_NullPointerException());
  }
  arrayOop s = arrayOop(JNIHandles::resolve_non_null(src));
  arrayOop d = arrayOop(JNIHandles::resolve_non_null(dst));
  assert(Universe::is_heap(s), "JVM_ArrayCopy: src not an oop");
  assert(Universe::is_heap(d), "JVM_ArrayCopy: dst not an oop");
  // Do copy
  Klass::cast(s->klass())->copy_array(s, src_pos, d, dst_pos, length, thread);
JVM_END