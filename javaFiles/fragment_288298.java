public static void main(String[] args) {
    final Collection<S> sColl = new ArrayList<>();
    final Collection<A> aColl = new ArrayList<>();
    final Collection<B> bColl = new ArrayList<>();

    final S s1 = Test.<S> extendsMax(sColl); // compiles, T = S, <? extends T> = S
    final S s2 = Test.<S> extendsMax(aColl); // compiles, T = S, <? extends T> = A
    final S s3 = Test.<S> extendsMax(bColl); // compiles, T = S, <? extends T> = B
    final A a1 = Test.<A> extendsMax(aColl); // compiles, T = A
    final B b1 = Test.<B> extendsMax(bColl); // compiles, T = B

    final S s4 = Test.<S> max(sColl); // compiles, T = S
    final S s5 = Test.<S> max(aColl); // does not compile, T = S, T != A
    final S s6 = Test.<S> max(bColl); // does not compile, T = S, T != B

    final S s7 = Test.max(aColl); // compiles, but because T = A, and A 
                                  // can be assigned to S
}