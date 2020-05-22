public class EmptyStringTypeHandler extends StringTypeHandler {

  @Override
  public String getResult(ResultSet rs, String columnName) throws SQLException {
    return unnulledString(super.getResult(rs, columnName));
  }

  @Override
  public String getResult(ResultSet rs, int columnIndex) throws SQLException {
    return unnulledString(super.getResult(rs, columnIndex));
  }

  @Override
  public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
    return unnulledString(super.getResult(cs, columnIndex));
  }

  private String unnulledString(String value) {
    return StringUtils.defaultString(value, "");
  }

}