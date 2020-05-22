Field[] allFields = Currency.class.getDeclaredFields();
    for (Field field : allFields) {
        if (Modifier.isPrivate(field.getModifiers()) && !field.isSynthetic()) {
            System.out.println(field.getName());
        }
    }