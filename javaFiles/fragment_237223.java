// Deliberate use of `new` to make sure JVM does not re-use a cached "EOT".
private static final String EOT = new String("EOT");
...
// Signal we're done.
queue.put(EOT);


// Meanwhile at the consumer end of the queue.
String got = queue.get();
if ( got == EOT ) {
  // Tidy shutdown
}