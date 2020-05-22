// CPU 0:
void shutDownWithFailure(void)
{
  failure = 1; // must use SOB as this is owned by CPU 1
  SFENCE // next instruction will execute after all SOBs are processed
  shutdown = 1; // can execute immediately as it is owned be CPU 0
}
// CPU1:
void workLoop(void)
{
  while (shutdown == 0) { ... }
  if (failure) { ...}
}