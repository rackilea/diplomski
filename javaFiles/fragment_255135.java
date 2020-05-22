void someMethod(){
    ClassInfo<B> b1 = (ClassInfo<B>) get1(); //does not compile
    ClassInfo<? extends B> b2 = (ClassInfo<? extends B>) get2(); //compiles
}

ClassInfo<A> get1() {
    return null;
}

ClassInfo<? extends A> get2() {
    return null;
}