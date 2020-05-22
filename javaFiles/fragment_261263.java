List<Object> rows = axlPort.executeSQLQuery(sqlParams)
                           .getReturn()
                           .getRow();
for(Object row : rows) {
    Element rowElement = (Element) row;
    // utilize DOM API
}