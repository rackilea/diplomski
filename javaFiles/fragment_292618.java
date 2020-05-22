> List<A> listA = new ArrayList<>();
[]

> listA.add(new A());
true

> List<? extends A> listExtendsA = new ArrayList<B>(); // B is a subclass of A
[]

> listExtendsA.add(new A());
Error:
incompatible types: A cannot be converted to capture#2 of ? extends A