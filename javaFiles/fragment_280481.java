import java.lang.reflect.Array;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class NdArrayCaster {
    private final static Map<Class<?>, NumberClassWrapper> TYPES = new HashMap<Class<?>, NumberClassWrapper>() {
        {
            put(byte.class, new ByteClassWrapper());
            put(short.class, new ShortClassWrapper());
            put(int.class, new IntClassWrapper());
            put(long.class, new LongClassWrapper());
            put(float.class, new FloatClassWrapper());
            put(double.class, new DoubleClassWrapper());
        }
    };

    /**
     * Returns a "deep casted" copy of ndArray with the given base type.
     */
    public static Object cast(Object ndArray, Class<?> baseTypeClass) {
        checkThatPrimitiveArray(ndArray);
        int dimension = getDimension(ndArray);
        NumberClassWrapper wrapper = TYPES.get(baseTypeClass);
        return cast(ndArray, wrapper, dimension);
    }

    /**
     * Throws an IllegalArgumentException if ndArray is not a primitive type array.
     */
    private static void checkThatPrimitiveArray(Object ndArray) {
        if (!ndArray.getClass().getName().matches("\\[*[BSIJFD]")) {
            throw new IllegalArgumentException("ndArray is not a primitive array.");
        }
    }

    /**
     * Returns the array's dimension.
     */
    private static int getDimension(Object ndArray) {
        return ndArray.getClass().getName().length() - 1;
    }

    /**
     * Casts an old to an array of the given type and dimension.
     * <p>
     * This is called recursive for each dimension.
     */
    private static Object cast(Object old, NumberClassWrapper wrapper, int dimension) {
        if (dimension == 0) {
            return wrapper.cast((Number) old);
        }

        int size = Array.getLength(old);
        Object newArray = wrapper.createArray(dimension, size);
        for (int i = 0; i < size; i++) {
            Object child = Array.get(old, i);
            Array.set(newArray, i, cast(child, wrapper, dimension - 1));
        }
        return newArray;
    }

    /**
     * Class providing information for a primitive type.
     */
    private static abstract class NumberClassWrapper<N extends Number> {
        private final Class<N> primitiveClass;
        private final String jvmName;

        NumberClassWrapper(Class<N> numberClass, String jvmName) {
            this.primitiveClass = numberClass;
            this.jvmName = jvmName;
        }

        /**
         * Casts a number to the type represented by this Wrapper.
         */
        abstract N cast(Number value);


        /**
         * Creates a primitive array with the given dimension and the given size at the lowest dimension.
         * <p>
         * Example: `IntClassWrapper.createArray(3,4)` returns the same as `new int[4][][]`.
         */
        final Object createArray(int dimension, int size) {
            return Array.newInstance(getBaseClassForArrayCreation(dimension), size);
        }

        Class getBaseClassForArrayCreation(int dimension) {
            if (dimension == 1) {
                return primitiveClass;
            } else {
                try {
                    return Class.forName(getArrayJVMName(dimension - 1));
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                    throw new Error("Cannot happen.");
                }
            }
        }

        /**
         * Returns the JVM name of the corresponding primitive array with the given dimension.
         */
        private String getArrayJVMName(int dimension) {
            return String.join("", Collections.nCopies(dimension, "[")) + jvmName;
        }
    }

    private final static class ByteClassWrapper extends NumberClassWrapper<Byte> {
        ByteClassWrapper() {
            super(byte.class, "B");
        }

        @Override
        public Byte cast(Number n) {
            return n.byteValue();
        }
    }


    private final static class ShortClassWrapper extends NumberClassWrapper<Short> {
        ShortClassWrapper() {
            super(short.class, "S");
        }

        @Override
        Short cast(Number n) {
            return n.shortValue();
        }
    }

    private final static class IntClassWrapper extends NumberClassWrapper<Integer> {
        IntClassWrapper() {
            super(int.class, "I");
        }

        @Override
        Integer cast(Number n) {
            return n.intValue();
        }
    }

    private final static class LongClassWrapper extends NumberClassWrapper<Long> {
        LongClassWrapper() {
            super(long.class, "J");
        }

        @Override
        Long cast(Number n) {
            return n.longValue();
        }
    }

    private final static class FloatClassWrapper extends NumberClassWrapper<Float> {
        FloatClassWrapper() {
            super(float.class, "F");
        }

        @Override
        Float cast(Number n) {
            return n.floatValue();
        }
    }

    private final static class DoubleClassWrapper extends NumberClassWrapper<Double> {
        DoubleClassWrapper() {
            super(double.class, "D");
        }

        @Override
        Double cast(Number n) {
            return n.doubleValue();
        }
    }

    public static void main(String... args) {
        // Sample data
        double[][][] array1 = {
                {{3D, 4D, 5D, 2D, 13D}, {8D}, {28D}},
                {{8D}, {4228.2D, 4D, -.29D, 3D}, {228D}},
                {{48D}, {228D}},
                {{48D}, {28D}}
        };
        double[][][] array2 = {
                {{8}, {3, 4, 5, 2, 3}, {28}},
                {{8}, {4228, 4, 29, 3}, {228}},
                {{248}, {228}},
                {{0}, {-2899}, {9}}
        };
        double[][][] array2Nulls = {
                {{8}, {3, 4, 5, 2, 3}, {28}},
                {{8}, {4228, 4, 29, 3}, {228}},
                {},
                {{0}, {-2899}, {9}}
        };

        double[][][] array3a = {
                {{8D}, {554D, 5D, 2D, 3D}, {28D}},
                {{48D}, {228D}},
                {{48D}, {328.65D}}
        };

        double[][][][] ndArray = {array1, array2, array2Nulls, array3a};
        System.out.println(cast(ndArray, byte.class).getClass());
        System.out.println(cast(ndArray, short.class).getClass());
        System.out.println(cast(ndArray, int.class).getClass());
        System.out.println(cast(ndArray, long.class).getClass());
        System.out.println(cast(ndArray, float.class).getClass());
        System.out.println(cast(ndArray, double.class).getClass());

        Object[] objectArray = new Object[]{new Object()};
        try {
            System.out.println(cast(objectArray, byte.class).getClass());
        } catch (IllegalArgumentException e) {
            System.out.println("Object array not working: check.");
        }
        try {
            System.out.println(cast(new Object(), byte.class).getClass());
        } catch (IllegalArgumentException e) {
            System.out.println("Object not working: check.");
        }
    }
}