public static String preparedQueryString(String staticQuery, Object... parameters) {
    for(Object curParameter : parameters) {
        if(curParameter instanceof String) {
            staticQuery = staticQuery.replaceFirst("\\?", "'" + curParameter.toString() + "'");
        } else {
            staticQuery = staticQuery.replaceFirst("\\?", curParameter.toString());
        }

    return staticQuery;
}