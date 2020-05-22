private void writeObject(java.io.ObjectOutputStream out) {
   out.defaultWriteObject();
   log.info("Object of type " + 
      getClass().getName() + " is being serialized");
   // optionally include a stacktrace here, or use a debugger, to see
   // when exactly it happened
}