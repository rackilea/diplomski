final Test[] test = new Test[20];
Supplier<Test> t = () -> test[10];
test[10] = new Test(7);
System.out.println(t.get().whatever); // Prints 7
test[10] = new Test(42);
System.out.println(t.get().whatever); // Prints 42