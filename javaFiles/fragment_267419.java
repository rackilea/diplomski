public static List<Contact> sortByFieldName(List<Contact> list, String fieldName) throws NoSuchFieldException {
    Field field = Contact.class.getDeclaredField(fieldName);
    if (!String.class.isAssignableFrom(field.getType())) {
        throw new IllegalArgumentException("Field is not a string!");
    }

    field.setAccessible(true);
    return list.stream()
        .sorted((first, second) -> {
            try {
                String a = (String) field.get(first);
                String b = (String) field.get(second);
                return a.compareTo(b);
            } catch (IllegalAccessException e) {
                throw new RuntimeException("Error", e);
            }
        })
        .collect(Collectors.toList());
}