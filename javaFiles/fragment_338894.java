// should timeout after five seconds
EndlessIterable iterable = new EndlessIterable(5, TimeUnit.SECONDS);
try {
 for(String s : iterable) { System.out.println(s); }
} catch(Exception e) {
  System.out.println("exception detected: " + e);
}
System.out.println("done");