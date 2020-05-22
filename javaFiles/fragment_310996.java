ArrayList<ArrayList<String>> row = new ArrayList<ArrayList<String>>();
ArrayList<String> column = new ArrayList<String>();

column.add("column1");
column.add("column2");
row.add(column);

  for (int i = 0; i < row.size(); i++) {
       for (int j = 0; j < column.size(); j++) {
           Log.d("values", row.get(i).get(j));
        }
     }