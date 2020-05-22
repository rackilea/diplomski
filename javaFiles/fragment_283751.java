private void tryItWildcard() {
    List<Class<? extends Number>> ints = new ArrayList<>();

    addClass(ints, Number.class); // does compile

    Class<? extends Number> aClass = ints.get(0);
}