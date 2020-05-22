/**
 * Return the set of fields declared at all level of class hierachy
 */
public Vector<Field> getAllFields(Class clazz) {
    return getAllFieldsRec(clazz, new Vector<Field>());
}

private Vector<Field> getAllFieldsRec(Class clazz, Vector<Field> vector) {
    Class superClazz = clazz.getSuperclass();
    if(superClazz != null){
        getAllFieldsRec(superClazz, vector);
    }
    vector.addAll(toVector(clazz.getDeclaredFields()));
    return vector;
}