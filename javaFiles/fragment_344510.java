public static boolean arrayContains(Object[] array, Object object) {
        if (array.getClass().getComponentType() != object.getClass()) {
            throw new IllegalArgumentException("Type of array and object are not equal! " + array.getClass().getComponentType().getName() + " != " + object.getClass().getName()); //$NON-NLS-1$ //$NON-NLS-2$
        }
        return Arrays.asList(array).contains(object);
    }