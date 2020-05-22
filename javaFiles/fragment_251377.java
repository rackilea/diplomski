Field[] allFields = Currency.class.getDeclaredFields();
    for (Field field : allFields) {
        if (Modifier.isPrivate(field.getModifiers())) {
            System.out.println(field.getName());
        }
    }