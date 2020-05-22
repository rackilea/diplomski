abstract class Foo {
    { // instance initializer code ensures that enforceDoCheckableVisibility
      // is invoked for every constructor
        enforceDoCheckableVisibility();
    }
    public Foo() {...}
    public Foo(Object o) {...}

    private void enforceDoCheckableVisibility() {
        Class<?> currentClass = getClass();
        while (currentClass != Foo.class) {
            try {
                Method doCheckableMethod = currentClass.getDeclaredMethod("doCheckable");
                if (Modifier.isPublic(doCheckableMethod.getModifiers())) {
                    throw new RuntimeException("Visibility of "
                                  + currentClass.getSimpleName()
                                  + ".doCheckable() must not be public");
                }
            } catch (SecurityException | NoSuchMethodException e) {}
            currentClass = currentClass.getSuperclass();
        }
    }
}