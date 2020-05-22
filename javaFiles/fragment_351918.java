// find out all the classes implementing MyInterface
Set<Class<? extends MyInterface>> subTypes = reflections.getSubTypesOf(MyInterface.class);

// iterate those classes and instntinate them
List<MyInterface> objects = new ArrayList<>();
for (Class<? extends MyInterface> clazz: subtypes) {
    objects.add(clazz.newInstance());
}