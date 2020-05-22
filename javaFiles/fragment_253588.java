CASE(_monitorenter): {
    oop lockee = STACK_OBJECT(-1);
    // derefing's lockee ought to provoke implicit null check
    CHECK_NULL(lockee);
    // find a free monitor or one already allocated for this object
    // if we find a matching object then we need a new monitor
    // since this is recursive enter
    BasicObjectLock* limit = istate->monitor_base();
    BasicObjectLock* most_recent = (BasicObjectLock*) istate->stack_base();
    BasicObjectLock* entry = NULL;
    while (most_recent != limit ) {
      if (most_recent->obj() == NULL) entry = most_recent;
      else if (most_recent->obj() == lockee) break;
      most_recent++;
    }
    if (entry != NULL) {
      entry->set_obj(lockee);
      markOop displaced = lockee->mark()->set_unlocked();
      entry->lock()->set_displaced_header(displaced);
      if (Atomic::cmpxchg_ptr(entry, lockee->mark_addr(), displaced) != displaced) {
        // Is it simple recursive case?
        if (THREAD->is_lock_owned((address) displaced->clear_lock_bits())) {
          entry->lock()->set_displaced_header(NULL);
        } else {
          CALL_VM(InterpreterRuntime::monitorenter(THREAD, entry), handle_exception);
        }
      }
      UPDATE_PC_AND_TOS_AND_CONTINUE(1, -1);
    } else {
      istate->set_msg(more_monitors);
      UPDATE_PC_AND_RETURN(0); // Re-execute
    }
}

CASE(_monitorexit): {
    oop lockee = STACK_OBJECT(-1);
    CHECK_NULL(lockee);
    // derefing's lockee ought to provoke implicit null check
    // find our monitor slot
    BasicObjectLock* limit = istate->monitor_base();
    BasicObjectLock* most_recent = (BasicObjectLock*) istate->stack_base();
    while (most_recent != limit ) {
      if ((most_recent)->obj() == lockee) {
        BasicLock* lock = most_recent->lock();
        markOop header = lock->displaced_header();
        most_recent->set_obj(NULL);
        // If it isn't recursive we either must swap old header or call the runtime
        if (header != NULL) {
          if (Atomic::cmpxchg_ptr(header, lockee->mark_addr(), lock) != lock) {
            // restore object for the slow case
            most_recent->set_obj(lockee);
            CALL_VM(InterpreterRuntime::monitorexit(THREAD, most_recent), handle_exception);
          }
        }
        UPDATE_PC_AND_TOS_AND_CONTINUE(1, -1);
      }
      most_recent++;
    }
    // Need to throw illegal monitor state exception
    CALL_VM(InterpreterRuntime::throw_illegal_monitor_state_exception(THREAD), handle_exception);
    ShouldNotReachHere();
}