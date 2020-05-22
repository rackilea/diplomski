private String extractWhereQueryPart(String input1, String input2, String input3) {
    List<String> sqlParts = new ArrayList<String>();

    if (StringUtils.isNotEmpty(input1)) {
        sqlParts.add(" INPUT1 = @input1 ");
    }

    if (StringUtils.isNotEmpty(input2)) {
        sqlParts.add(" INPUT2 = @input2 ");
    }

    // and so on

    if(sqlParts.isEmpty()) {
        return "";
    }

    return " WHERE " + StringUtils.join(sqlParts, " AND ");
}