bar = 0; // declared before the if block, visible inside and out
if (foo) {
   bar = 1; // this variable is visible outside of the if block
   int baz = 1; // this variable is not visible outside of the if block
}

System.out.println("bar = " + bar); // legal
System.out.println("baz = " + baz); // illegal