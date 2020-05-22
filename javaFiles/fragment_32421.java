//query a full sql command
public static ArrayList<HashMap<String,Object>> 
rawQuery(String fullCommand) {
  try {

    //create statement
    Statement stm = null;
    stm = con.createStatement();

    //query
    ResultSet result = null;
    boolean returningRows = stm.execute(fullCommand);
    if (returningRows)
      result = stm.getResultSet();
    else
      return new ArrayList<HashMap<String,Object>>();

    //get metadata
    ResultSetMetaData meta = null;
    meta = result.getMetaData();

    //get column names
    int colCount = meta.getColumnCount();
    ArrayList<String> cols = new ArrayList<String>();
    for (int index=1; index<=Col_Count; index++)
      cols.add(meta.getColumnName(index));

    //fetch out rows
    ArrayList<HashMap<String,Object>> rows = 
    new ArrayList<HashMap<String,Object>>();

    while (result.next()) {
      HashMap<String,Object> row = new HashMap<String,Object>();
      for (String colName:cols) {
        Object val = Result.getObject(colName);
        row.put(colName,val);
      }
      rows.add(row);
    }

    //close statement
    stm.close();

    //pass back rows
    return tows;
  }
  catch (Exception ex) {
    System.out.print(ex.getMessage());
    return new ArrayList<HashMap<String,Object>>();
  }
}//raw_query