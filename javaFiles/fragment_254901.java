public static <T> OngoingStubbing<T> switchAfter(
              OngoingStubbing<T> stub, int calls, Supplier<T> first, Supplier<T> then) {
    Answer<T> a1=x -> first.get(), a2=x -> then.get();
    while(calls-->0) stub=stub.then(a1);
    return stub.then(a2);
}