while (rs.next()) {
   map = new HashMap<>(); //create one new map for every row
   for (int i = 1; i <= columnCount; i++ ) {
        map.put(rsmd.getColumnName(i), rs.getString(i));
   }
   output.add(map);
}