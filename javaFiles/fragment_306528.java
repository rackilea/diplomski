try {
  // return c.newInstance(); -- DEPRECATED as of Java 9
  return c.getConstructor().newInstance();
} catch (Exception e) {
  // handle case of no such public, no-arg constructor
}