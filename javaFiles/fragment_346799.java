public static String getPKColumnName(Class<?> pojo) {

    if (pojo == null) 
        return null;

    String name = null;

    for (Field f : pojo.getDeclaredFields()) {

        Id id = null;
        Column column = null;

        Annotation[] as = f.getAnnotations();
        for (Annotation a : as) {
            if (a.annotationType() == Id.class) 
                id = (Id) a;
            else if (a.annotationType() == Column.class) 
                column = (Column) a;
        }

        if (id != null && column != null){
            name = column.name();
            break;
        }
    }

    if (name == null && pojo.getSuperclass() != Object.class)
        name = getPKColumnName(pojo.getSuperclass());

    return name;
}