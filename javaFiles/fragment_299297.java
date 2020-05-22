public static Class<? extends AEntity> getEntityType(Object o) throws Exception {
    for (Field field : o.getClass().getDeclaredFields()) {
        if (AEntityDefinition.class.isAssignableFrom(field.getType())) {
            AEntityDefinition def = (AEntityDefinition) field.get(o);
            return def.getEntity().getClass();
        }
    }
    return null;
}