inline void GC_locker::lock_critical(JavaThread* thread) {
  if (!thread->in_critical()) {
    if (needs_gc()) {
      // jni_lock call calls enter_critical under the lock so that the
      // global lock count and per thread count are in agreement.
      jni_lock(thread);   <-- SLOW PATH
      return;
    }
    increment_debug_jni_lock_count();
  }
  thread->enter_critical();  <-- FAST PATH
}