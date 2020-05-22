HashMap<String, String> map = new HashMap<>();
for (Field field: ConstClass.class.getFields()) {
    if (String.class.isAssignableFrom(field.getType())) {
        int modifiers = field.getModifiers();
        if (Modifier.isStatic(modifiers)) {
            map.put(field.getName(), (String) field.get(ConstClass.class));
        }
    }
}