case method_entry: {
  /* CODE_EDIT: irrelevant code removed for brevities sake */

  // lock method if synchronized
  if (METHOD->is_synchronized()) {
      // oop rcvr = locals[0].j.r;
      oop rcvr;
      if (METHOD->is_static()) {
        rcvr = METHOD->constants()->pool_holder()->java_mirror();
      } else {
        rcvr = LOCALS_OBJECT(0);
        VERIFY_OOP(rcvr);
      }
      // The initial monitor is ours for the taking
      BasicObjectLock* mon = &istate->monitor_base()[-1];
      oop monobj = mon->obj();
      assert(mon->obj() == rcvr, "method monitor mis-initialized");

      bool success = UseBiasedLocking;
      if (UseBiasedLocking) {
        /* CODE_EDIT: this code is only run if you have biased locking enabled as a JVM option */
      }
      if (!success) {
        markOop displaced = rcvr->mark()->set_unlocked();
        mon->lock()->set_displaced_header(displaced);
        if (Atomic::cmpxchg_ptr(mon, rcvr->mark_addr(), displaced) != displaced) {
          // Is it simple recursive case?
          if (THREAD->is_lock_owned((address) displaced->clear_lock_bits())) {
            mon->lock()->set_displaced_header(NULL);
          } else {
            CALL_VM(InterpreterRuntime::monitorenter(THREAD, mon), handle_exception);
          }
        }
      }
  }

  /* CODE_EDIT: irrelevant code removed for brevities sake */

  goto run;
}