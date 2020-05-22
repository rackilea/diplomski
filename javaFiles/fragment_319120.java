String columnName = rs.getString("ARGUMENT_NAME");
if (index == 0) {
    columnName = RETURN_VALUE;
}
String columnDataTypeInString = rs.getString("DATA_TYPE");
String columnReturnInString = rs.getString("IN_OUT");