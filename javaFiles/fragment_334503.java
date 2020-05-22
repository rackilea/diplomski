List<Integer> foo = Arrays.asList(1,2,3);
List<String> bar = Arrays.asList("hi","mom");
List<List<? extends Serializable>> baz = Arrays.asList(foo, bar);
doSomethingWithListOfSerializables(baz);

public void doSomethingWithListOfSerializables(
        List<? extends List<? extends Serializable>> listList) {

    captureTheWildcard(listList); 
}

private <T extends Serializable>
        void captureTheWildcard(
                List<? extends List<T>> listList) {

    // Do something
}