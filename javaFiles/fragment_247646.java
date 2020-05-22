public static List<Field> getAllFields(List<Field> fields, Class<?> type) {
    fields.addAll(Arrays.asList(type.getDeclaredFields()));

    if (type.getSuperclass() != null) {
        getAllFields(fields, type.getSuperclass());
    }

    return fields;
}

@Test
public void getLinkedListFields() {
    System.out.println(getAllFields(new LinkedList<Field>(), LinkedList.class));
}