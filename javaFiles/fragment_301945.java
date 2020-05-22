/**
 * Collect all fields declared, including superclasses.
 * @param type class
 * @return
 */
public static List<Field> getAllFields(Class<?> type) {
    List<Field> fields = new ArrayList<>();
    getAllFieldsRecursive(fields, type);
    return fields;
}

/**
 * Get fields recursively, starting from child.
 * Starting from child is important to support fields overriding.
 * @param fields all fields collected
 * @param type currently scanned class
 * Example:
 * class A {String myfield; String otherField}
 * class B extends class A {String myField; String bField}
 * Result: String B.myfield; String B.bField; String A.otherField
 */
private static void getAllFieldsRecursive(List<Field> fields, Class<?> type) {
    List<Field> declaredFields = Arrays.asList(type.getDeclaredFields()); //Start from child
    for (Field declaredField : declaredFields){
        if (!genericContainsField(declaredField, fields))
            fields.add(declaredField); //if field is not overridden in child, add it
    }
    if (type.getSuperclass() != null) {
        getAllFieldsRecursive(fields, type.getSuperclass());
    }
}

/**
 *
 * @param declaredField field we are comparing
 * @param fields current fields list
 * @return
 */
private static boolean genericContainsField(Field declaredField, List<Field> fields){
    for (Field field:fields){
        if (genericEqualsFields(field, declaredField))
            return true;
    }
    return false;
}

/**
 * Compares this {@code Field} against the specified object.  Returns
 * true if the objects are the same.  Two {@code Field} objects are the same if
 * they were have the same name and type.
 * Declared by the same class is NOT needed
 * Hack for Generic lookup, based on Field.equals()
 */
private static boolean genericEqualsFields(Field obj, Field other) {
    return (obj.getName() == other.getName())
            && (obj.getType() == other.getType());
}