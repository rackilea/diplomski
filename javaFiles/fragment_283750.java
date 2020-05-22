private void addClass(List<Class<? extends Number>> list, Class<Number> c) {
    list.add(c);
    list.add(list.get(0));
}

private void tryItSubclass() {
    List<Class<Integer>> ints = new ArrayList<>();

    addClass(ints, Number.class); // does not compile 
}