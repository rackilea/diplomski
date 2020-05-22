Class<?> topClass = ...

for (Class<?> innerClass : topClass.getDeclaredClasses()) {
    for (Field field : innerClass.getDeclaredFields()) {
        if (Modifier.isPrivate(field.getModifiers())) {
            String name = Character.toUpperCase(field.getName().charAt(0)) 
                        + field.getName().substring(1);
            Method getter;
            try {
                getter = innerClass.getDeclaredMethod("get" + name);
            } catch (Exception ex) {
                getter = null;
            }
            Method setter;
            try {
                setter = innerClass.getDeclaredMethod("set" + name, field.getType());
            } catch (Exception ex) {
                setter = null;
            }

            // TODO real work...
            System.out.printf("%s: getter=%s, setter=%s%n", 
                              innerClass.getSimpleName(), getter, setter);
        }
    }
}