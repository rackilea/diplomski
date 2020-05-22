2811     ThreadState old_state = thread->osthread()->get_state();
 2812     thread->osthread()->set_state(SLEEPING);
 2813     if (os::sleep(thread, millis, true) == OS_INTRPT) {
 2814       // An asynchronous exception (e.g., ThreadDeathException) could have been thrown on
 2815       // us while we were sleeping. We do not overwrite those.
 2816       if (!HAS_PENDING_EXCEPTION) {
 2817         HS_DTRACE_PROBE1(hotspot, thread__sleep__end,1);
 2818         // TODO-FIXME: THROW_MSG returns which means we will not call set_state()
 2819         // to properly restore the thread state.  That's likely wrong.
 2820         THROW_MSG(vmSymbols::java_lang_InterruptedException(), "sleep interrupted");
 2821       }
 2822     }
 2823     thread->osthread()->set_state(old_state);