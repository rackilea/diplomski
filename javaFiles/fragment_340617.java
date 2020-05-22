StringBuilder sqlsb = new StringBuilder("select column1 from table2");
boolean isOrderbyAdded = false;
for(int i=1; i<N; i++) { // N is a known integer (e.g. 5)
  if(column[i]!=null) {
    if(!isOrderbyAdded) {
      sqlsb.append(" order by ");
          isOrderbyAdded = true;
    } else {
      sqlsb.append(", ");
    }
    sqlsb.append(column[i]);
  }
}
String sql = sqlsb.toString();