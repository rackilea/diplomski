public Object insert(Object objeto){
  final DataSource<?> dataSource = dataSourcesMap.get(objeto.getClass());
  if(dataSource!=null) {
      assert dataSource.getDataType().isInstance(objeto);
      return doInsert(dataSource, objeto);
  } else {
     throw new RuntimeException(ErrorMessages.NAO_EXISTE_DATA_SOURCE.toString());
  }
}
private static <T> T doInsert(DataSource<T> ds, Object o) {
  return ds.insert(ds.getDataType().cast(o));
}