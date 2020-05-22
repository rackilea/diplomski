public Object methodName(ProceedingJointPoint pjp) throws Throwable {

...

 try {
   return pjp.proceed();
 } catch (Throwable t) {
   // so something with t: log, wrap, return default, ...
   log.warn("invocation of " + pjp.getSignature().toLongString() + " failed", t);
   // I hate logging and re-raising, but let's do it for the sake of this example
   throw t;
 }