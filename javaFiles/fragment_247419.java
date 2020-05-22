List<object[]> records=new ArrayList<object[]>();
while(resultSet.next()){
    int cols = resultSet.getMetaData().getColumnCount();
    Object[] arr = new Object[cols];
    for(int i=0; i<cols; i++){
      arr[i] = resultSet.getObject(i+1);
    }
    records.add(arr);
}