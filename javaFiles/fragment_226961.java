private HashMap<String, Class<? extends List>> layoutsByName  = new HashMap<>();

public Class<? extends Layout> getLayout(String name) {
    Class<? extends Layout> layoutClass = layoutsByName.get(name);
    if(layoutClass!=null) {
        return layoutClass;
    }
    layoutClass = getLayoutUsingReflection(name);
    layoutsByName.put(name, layoutClass);
    return layoutClass;
}

private Class<? extends Layout> getLayoutUsingReflection(String name) {
    try {
        return (Class<? extends Layout>) Class.forName(name);
    } catch (ClassNotFoundException e) {
        return DefaultLayout.class;
    }
}