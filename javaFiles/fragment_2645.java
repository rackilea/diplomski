class B extends A { ... }

Collection<A> collecA;
List<B> listB;

collecA = listB;  // normally an error, but lets pretend its allowed

collecA.add(new A()); // PROBLEM!