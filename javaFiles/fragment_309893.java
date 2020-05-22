class A {
    void say(List<? extends Number> numbers) { }
}

class B extends A {
    void say(List<Number> numbers) { numbers.add(Double.valueOf(1.0)); }
}


List<Integer> onlyIntsPlease = new ArrayList<Integer>();
B b = new B();

// Oops! The list of `Integer` will now contain a `Double`...
b.say(onlyIntsPlease);