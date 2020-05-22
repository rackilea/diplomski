Method[] allMethods = Test.class.getDeclaredMethods();
for (Method method : allMethods) {
    if (Modifier.isPublic(method.getModifiers())) {
        System.out.println(method);
        // use the method
    }
}