public void debug(Object message, Throwable t) {
  if(repository.isDisabled(Level.DEBUG_INT))
    return;

  if(Level.DEBUG.isGreaterOrEqual(this.getEffectiveLevel()))
    forcedLog(FQCN, Level.DEBUG, message, t);
}