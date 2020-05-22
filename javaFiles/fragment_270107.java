try {
  // fragile operation
} catch (RuntimeException e) {
  PSQLException psqle = getCauseOfClass(e, PSQLException.class);
  // warn, or retry or whatever
  // ...
  // if exception doesn't contain cause of requred type, it will be rethrown
}