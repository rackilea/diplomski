public void foo(String[] args) {}

 ...

 // Valid
 foo(new String[] { "a", "b", "c" };

 // Invalid
 foo({"a", "b", "c"});