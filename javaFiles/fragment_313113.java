public static List<Entity> getEntities() {
    return Arrays.stream(Foo.class.getMethods()).
            filter(method -> method.getReturnType() == Entity.class && 
                             Modifier.isStatic(method.getModifiers())).
            map(method -> {
                try {
                    return (Entity)method.invoke(null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    throw new RuntimeException(e); // exceptions in streams... lol
                }
            }).
            collect(Collectors.toList());
}