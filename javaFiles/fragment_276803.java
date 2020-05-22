Object cloneObject(Object obj) {
    Class<?> type = obj == null ? Object.class : obj.getClass();
    if (type.isArray()) {
        Class<?> elemType = type.getComponentType();
        if (!elemType.isPrimitive()) {
            Object[] copy = ...
        } else {
            // Must distinguish between int/double/boolean/...
            ... int[] ... double[] ...
        }
    }

Object inta = new int[] { 2, 3, 5, 7 };
int[] pr = (int[]) cloneObject(inta);