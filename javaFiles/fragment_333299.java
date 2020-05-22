class A<T> {}
class B<T> extends A<T> {}
class C extends B<String> {}

// Resolve the type argument for A using type information from C
Class<?> t = TypeResolver.resolveRawArgument(A.class, C.class);
assert t == String.class;