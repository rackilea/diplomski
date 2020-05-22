void foo(Object o) {
  if (o instanceof Number) { foo((Number) o); }
  else if (o instanceof String) { foo((String) o); }
}

void foo(String s) { ... }

void foo(Number n) { ... }

{ foo((Object) "foo"); }  // Calls foo(Object) which calls foo(String).
{ foo("foo"); }  // Calls foo(String) without first calling foo(Object).