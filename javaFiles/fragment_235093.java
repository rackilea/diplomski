static Object[] convertToObjectArray(Object array) {
    Class ofArray = array.getClass().getComponentType();
    if (ofArray.isPrimitive()) {
        List ar = new ArrayList();
        int length = Array.getLength(array);
        for (int i = 0; i < length; i++) {
            ar.add(Array.get(array, i));
        }
        return ar.toArray();
    }
    else {
        return (Object[]) array;
    }
}