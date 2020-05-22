String field1 = getField(request, "field1", true);
String field2 = getField(request, "field2", true);
String field3 = getField(request, "field3", false);

...

public static String getField(HttpServletRequest request, String fieldName, boolean required) throws ValidatorException {
    String fieldValue = request.getParameter(fieldName);
    if (fieldValue == null || fieldValue.trim().isEmpty()) {
        if (required) {
            throw new ValidatorException("Field is required");
        } else {
            fieldValue = null; // Make empty string null so that you don't need to hassle with equals("") afterwards.
        }
    }
    return fieldValue;
}