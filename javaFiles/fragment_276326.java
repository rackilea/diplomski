final A<Integer> test = new A<Integer>(3, 2);
test.setTheFunction(new Callable<Integer>() {
    int x = test.a * test.b;
    return x * x + 2;
});
System.out.println(test.theFunction());