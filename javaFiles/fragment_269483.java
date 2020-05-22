static Runnable wrap(Runnable task)
{
  Thread caller = Thread.currentThread();
  return () -> {
    Iterable<ThreadLocal<?>> vars = copy(caller);
    try {
      task.run();
    }
    finally {
      for (ThreadLocal<?> var : vars)
        var.remove();
    }
  };
}

/**
 * For each {@code ThreadLocal} in the specified thread, copy the thread's 
 * value to the current thread.  
 * 
 * @param caller the calling thread
 * @return all of the {@code ThreadLocal} instances that are set on current thread
 */
private static Collection<ThreadLocal<?>> copy(Thread caller)
{
  /* Use a nasty bunch of reflection to do this. */
  throw new UnsupportedOperationException();
}