if (method_unlock_needed) {
    if (base->obj() == NULL) {
      /* CODE_EDIT: irrelevant code removed for brevities sake */
    } else {
      oop rcvr = base->obj();
      if (rcvr == NULL) {
        if (!suppress_error) {
          VM_JAVA_ERROR_NO_JUMP(vmSymbols::java_lang_NullPointerException(), "");
          illegal_state_oop = THREAD->pending_exception();
          THREAD->clear_pending_exception();
        }
      } else {
        BasicLock* lock = base->lock();
        markOop header = lock->displaced_header();
        base->set_obj(NULL);
        // If it isn't recursive we either must swap old header or call the runtime
        if (header != NULL) {
          if (Atomic::cmpxchg_ptr(header, rcvr->mark_addr(), lock) != lock) {
            // restore object for the slow case
            base->set_obj(rcvr);
            {
              // Prevent any HandleMarkCleaner from freeing our live handles
              HandleMark __hm(THREAD);
              CALL_VM_NOCHECK(InterpreterRuntime::monitorexit(THREAD, base));
            }
            if (THREAD->has_pending_exception()) {
              if (!suppress_error) illegal_state_oop = THREAD->pending_exception();
              THREAD->clear_pending_exception();
            }
          }
        }
      }
    }
}