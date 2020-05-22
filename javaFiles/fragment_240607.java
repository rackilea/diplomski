Class A {
    List<B> bs;

    transient List<C> cs;
}

Class B {
   List<C> cs;
}

Class C {
   String n; 
}