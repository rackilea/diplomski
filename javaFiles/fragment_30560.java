public boolean excludeColumn(TableIdentifier identifier, String columnName) {
  if(columnName.startsWith("uid_")) {
     return true;
  }
  return delegate==null?false:delegate.excludeColumn(identifier, columnName);
}