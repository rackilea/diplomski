/**
 * @param field The field name
 * @return True is there are errors related to this field
 */
public static boolean hasError(String field) {
    return error(field) != null;
}