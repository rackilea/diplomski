void myFunction(ChangeableInt arg) {
   arg.set(42);
}
...
ChangeableInt val = new ChangeableInt(123);
myFunction(val);
System.out.println(val.get()); // prints 42