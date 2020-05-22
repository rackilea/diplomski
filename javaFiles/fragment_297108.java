import java.lang.reflect.Array;

public class ArrayTransfer {

    private static int getArrayDimension(Object array) {
        Class<?> clazz = array.getClass();
        int dimension = 0;
        while (clazz.isArray()) {
            clazz = clazz.getComponentType();
            dimension += 1;
        }

        if (clazz != boolean.class) {
            throw new IllegalArgumentException("Base array type not boolean");
        }

        return dimension;
    }

    // Transfers a boolean array of the specified dimension into an int
    // array of the same dimension.
    private static Object transferToIntArray(Object booleanArray, int dimension) {
        if (booleanArray == null) {
            return null;
        }

        // Determine the component type of the new array.
        Class<?> componentType;
        if (dimension == 1) {
            componentType = int.class;
        } else {
            // We have a multidimensional array; the dimension of the component
            // type is one less than the overall dimension.  Creating the class
            // of an array of an unknown dimension is slightly tricky: we do
            // this by creating a 0 x 0 x ... x 0 array (with dimension - 1
            // zeros) and then getting the class of this array.  Handily for us,
            // int arrays are initialised to all zero, so we can create one and
            // use it straight away.
            int[] allZeroDimensions = new int[dimension - 1];
            componentType = Array.newInstance(int.class, allZeroDimensions).getClass();
        }

        // Create the new array.
        int length = Array.getLength(booleanArray);
        Object newArray = Array.newInstance(componentType, length);

        // Transfer the elements, recursively if necessary.
        for (int i = 0; i < length; ++i) {
            if (dimension == 1) {
                Boolean value = (Boolean)Array.get(booleanArray, i);
                Array.set(newArray, i, (value.booleanValue()) ? 1 : 0);
            }
            else {
                Object oldChildArray = Array.get(booleanArray, i);
                Object newChildArray = transferToIntArray(oldChildArray, dimension - 1);
                Array.set(newArray, i, newChildArray);
            }
        }

        return newArray;
    }

    // Transfers a boolean array of some dimension into an int
    // array of the same dimension.
    public static Object transferToIntArray(Object booleanArray) {
        if (booleanArray == null) {
            return null;
        }

        int dimension = getArrayDimension(booleanArray);
        return transferToIntArray(booleanArray, dimension);
    }
}