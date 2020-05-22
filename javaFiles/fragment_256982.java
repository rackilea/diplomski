public void deleteFieldsByName(LeadDetailsSRO details, List<String> fieldNames) throws Exception {
    for (String fieldName : fieldNames) {
        Field field = LeadDetailsSRO.class.getDeclaredField(fieldName);

        // this is usually not allowed at production settings
        field.setAccessible(true);


        Class fieldType = field.getType();

        // the following if-else is ugly.
        // But that's what we can do. We have to differentiate by classes.
        if (fieldType.equals(String.class)) {
            field.set(details, null);
        } else if (fieldType.equals(Set.class)) {
            field.set(details, new HashSet<>());
        } else if (fieldType.toString().equals("int")) {
            field.set(details, 0);
        }
    }