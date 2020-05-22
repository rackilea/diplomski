class ChocolateTester extends FooTester {
            boolean test(Foo inputFoo) {
                    Method chocolateMethod = inputFoo.getClass().getMethod("chocolate");
                    Result x = chocolateMethod.invoke(inputFoo);
                    return validate(x);
            }
            private validate(x) {...}
    }