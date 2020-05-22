if(object.getClass().isArray()) {
        int length = Array.getLength(object);
        Object array = Array.newInstance(object.getClass().getComponentType(), length);
        for (int i = 0; i < length; i++) {
            Array.set(array, i, clone(Array.get(object, i), true));
        }
        return (T) array;
    }