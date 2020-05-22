for (Map.Entry<String, String[]> entry: request.getParameterMap()) {
    String parameterName = entry.getKey();
    if (parameterName.startsWith("qryStr")) {
        // do what you want with the parameter name and its values
    }
}