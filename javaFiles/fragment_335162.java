static {
    Map<Class,String[]> map = new HashMap<Class,String[]>();
    map.put(Reflection.class,
        new String[] {"fieldFilterMap", "methodFilterMap"});
    map.put(System.class, new String[] {"security"});
    fieldFilterMap = map;

    methodFilterMap = new HashMap<Class,String[]>();
}