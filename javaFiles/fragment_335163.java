public static Field[] filterFields(Class containingClass,
                                   Field[] fields) {
    if (fieldFilterMap == null) {
        // Bootstrapping
        return fields;
    }
    return (Field[])filter(fields, fieldFilterMap.get(containingClass));
}