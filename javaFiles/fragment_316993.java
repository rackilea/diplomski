int count = 0;
for (Field field : MyClassName.class.getDeclaredFields()) {
    int modifiers = field.getModifiers();
    if (Modifier.isStatic(modifiers)) {
        if (field.getName().startsWith("DB_")) {
            count++;
        }
    }
}