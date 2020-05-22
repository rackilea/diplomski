/**
 * Compare objects for equal value, with some disregard for type.
 * <p>
 * The following types are considered similar, for the purpose of comparing values. The
 * values of the secondary types are converted to the first listed type for value comparison.
 * <ul>
 * <li>{@code long}, {@code int}, {@code short}</li>
 * <li>{@code double} <i>(rounded to 3 decimals before comparing)</i></li>
 * <li>{@code String}, {@code Timestamp}</li>
 * <li>Array <i>(elements are compared using this method, comparison is "deep")</i></li>
 * </ul>
 * Values for all other types are only considered equal if they have the exact same type
 * and {@code equals()} return {@code true}.
 * 
 * @param obj1 the first object to be compared.
 * @param obj2 the second object to be compared.
 * @return {@code true} only if the specified objects are equals according to the rules listed above.
 */
public static boolean equalValue(Object obj1, Object obj2) {
    // Compare null values
    if (obj1 == null)
        return (obj2 == null);
    if (obj2 == null)
        return false;

    Class<?> class1 = obj1.getClass();
    Class<?> class2 = obj2.getClass();

    // Compare double values, rounded to 3 decimal places
    if (class1 == Double.class && class2 == Double.class) {
        // Can't use Math.round() because it doesn't do round-half-up, and may overflow long value-range
        BigDecimal dec1 = BigDecimal.valueOf(((Number)obj1).doubleValue()).setScale(3, RoundingMode.HALF_UP);
        BigDecimal dec2 = BigDecimal.valueOf(((Number)obj2).doubleValue()).setScale(3, RoundingMode.HALF_UP);
        return dec1.equals(dec2); // equals() is ok, since we know they have same scale
    }

    // Compare arrays
    if (class1.isArray() && class2.isArray()) {
        int len = Array.getLength(obj1);
        if (len != Array.getLength(obj2))
            return false;
        for (int i = 0; i < len; i++)
            if (! equalValue(Array.get(obj1, i), Array.get(obj2, i)))
                return false;
        return true;
    }

    // Now that special cases are done, apply simple comparison for values of same type
    if (class1 == class2)
        return obj1.equals(obj2);

    // Compare long/int/short values
    if ((class1 == Long.class || class1 == Integer.class || class1 == Short.class) &&
        (class2 == Long.class || class2 == Integer.class || class2 == Short.class)) {
        return ((Number)obj1).longValue() == ((Number)obj2).longValue();
    }

    // Compare String/Timestamp values
    if ((class1 == String.class || obj1 instanceof Timestamp) &&
        (class2 == String.class || obj2 instanceof Timestamp)) {
        return obj1.toString().equals(obj2.toString());
    }

    return false; // Incomparable types
}