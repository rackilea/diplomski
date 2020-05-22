public SomeClass instantiate(String name)
  throws ClassNotFoundException, InstantiationException, IllegalAccessException {

    Class<?> raw = Class.forName(name);

    //throws ClassCastException if wrong
    Class<? extends SomeClass> generic = raw.asSubclass(SomeClass.class);

    // do what you want with `generic`

    return generic.newInstance();
}