public static List<String> getPublicDeclaredMethods(Class<?> clazz) {
    List<String> strings = new ArrayList<String>();
    Method[] methods = clazz.getDeclaredMethods();
    for(Method method : methods)  {
        if(Modifier.isPublic(method.getModifiers())) {
            strings.add(method.getName());
        }
    }
    return strings;
}