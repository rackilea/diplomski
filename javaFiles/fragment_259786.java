public <T, S extends T> List<T> refsToObjects(List<Ref<S>> list) {
    List<T> result = new ArrayList<T>();
    for(Ref<S> ref : list) {
        result.add(ref.get());
    }
    return result;
}