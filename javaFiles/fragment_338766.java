for (Field targetField : targetClass.getDeclaredFields()) {
        if (!Modifier.isFinal(targetField.getModifiers())) {
            targetField.setAccessible(true);
            Field field =
                instance.getClass().getDeclaredField(targetField.getName());
            field.setAccessible(true);
            targetField.set(target, field.get(instance));
         }
     }