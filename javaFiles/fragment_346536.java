List<Map> createTable(List queryResults) {
    List<Map> r = new LinkedList<Map>();
    for (Object o : queryResults) {
         r.add(entityMap(o));
    }
    return r;
}

Map entityMap(Object obj) throws Throwable {
    Map m = new HashMap();
    for (Field field : getFields(obj.getClass())) {
        Method method = getMethod(field);
        Object value = method.invoke(obj);
        m.put(field, value);
    }
    return m;
}

List<Field> getFields(Class<?> clazz) {
    List<Field> fields = new LinkedList<Field>();

    for (Field field : clazz.getDeclaredFields()) {
        Column col = field.getAnnotation(Column.class);
        if (col != null)
            fields.add(field);
    }
    return fields;
}

Method getMethod(Field field) throws NoSuchMethodException {
    Class<?> clazz = field.getDeclaringClass();
    String name = "get" + uppercase(field.getName());
    Method method = clazz.getMethod(name);
    return method;
}

String uppercase(String str) {
    return str.substring(0,1).toUpperCase() + str.substring(1);
}