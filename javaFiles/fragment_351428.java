class A {}

class B {}

class Link<F,T> {
    F from;
    T to;
}

class Structure {
    List<A> a;
    List<B> b;
    List<Link<A,B>> a2b;
    List<Link<B,A>> b2a;
}