public final void awaitUninterruptibly() {
  Node node = addConditionWaiter();
  int savedState = fullyRelease(node);
  boolean interrupted = false;
  while (!isOnSyncQueue(node)) {
    LockSupport.park(this);
    if (Thread.interrupted()) interrupted = true;
  }
  if (acquireQueued(node, savedState) || interrupted) selfInterrupt();
}