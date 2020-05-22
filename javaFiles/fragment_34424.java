Map<String, Integer> myMap = new HashMap<String, Integer>();
...
// parsing the column each time is a linear search
int column1Pos = rs.findColumn("Column1");
int column2Pos = rs.findColumn("Column2");
while (rs.next()) {
    String column1 = rs.getString(column1Pos);
    int column2 = rs.getInt(column2Pos);
    myMap.put(column1, column2);
}