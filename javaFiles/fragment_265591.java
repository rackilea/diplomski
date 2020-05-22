private static void handleDeclaredVariable(final JSONObject variable) {
    final String variableName = (String) variable.get("declared-variable");
    final Object value = variable.get("value");
    if (value instanceof JSONObject) {
        final JSONObject jsonValue = (JSONObject) value;
        final String operator = (String) jsonValue.get("operator");
        final JSONArray arguments = (JSONArray) jsonValue.get("arguments");
        System.out.println(
            String.format(
                "The value of the variable %s is a JSON object: operator: %s, arguments: %s",
                variableName,
                operator,
                arguments
            )
        );
    } else if (value instanceof Number) {
        final Number numberValue = (Number) value;
        System.out.println(
            String.format(
                "The value of the variable %s is a Number: %s",
                variableName,
                numberValue
            )
        );
    } else {
        System.err.println(
            String.format(
                "The value of the variable %s has unsupported type (%s): %s",
                variableName,
                value.getClass().getCanonicalName(),
                value
            )
        );
    }
}