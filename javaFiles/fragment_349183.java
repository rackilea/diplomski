List<Class<?>> types = new ArrayList<>();
types.add(Type1.class);
types.add(Type2.class);

for (Class<?> type : types) {
    if (type.isAssignableFrom(someObject.getClass())) {
        doSomething();
    }
}