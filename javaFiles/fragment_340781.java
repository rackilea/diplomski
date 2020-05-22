Collection<Field> fieldsWithAnnotation = new ArrayList<>();

    Class<?> clazz = // your class

    while(clazz != null) {
        for (Field field : clazz.getDeclaredFields()) {
            DynamicReference dynamicRefrence = field.getAnnotation(DynamicReference.class);
            if(dynamicRefrence != null)
                fieldsWithAnnotation.add(field);
        }
        clazz = clazz.getSuperclass();
    }