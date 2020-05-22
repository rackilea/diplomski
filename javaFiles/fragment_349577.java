public class Test {

    static class A {}
    static class B extends A {}


    public static void main(String[] args) throws Exception {
        Holder<HashSet<Integer>> i = newObjectHolder(new TypeReference<HashSet<Integer>>() {});  // works
        Holder<A> j = newObjectHolder(new TypeReference<A>() {});  // works
        Holder<A> k = newObjectHolder(new TypeReference<B>() {});  // works
        Holder<B> l = newObjectHolder(new TypeReference<A>() {});  // doesn't compile (good)
    }

    static class Holder<T> {
        public Holder(T newInstance) {}
        T get() { return null; }
    }

    public static <T,U extends TypeReference<? extends T>> Holder<T> newObjectHolder(U typeToken) throws Exception {
        T obj = typeToken.newInstance();
        return new Holder<T>(obj);
    }
}