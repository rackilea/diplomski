LinkedHashSet[] sets = new LinkedHashSet[]{
    new LinkedHashSet(), 
    new LinkedHashSet(),
    new LinkedHashSet(),
    new LinkedHashSet() };

while(resultSet.next()) {     
    sets[0].add(resultSet.getInt("SEQUENCE_NO"));
    sets[1].add(resultSet.getString("TABLE_NAME")););
    sets[2].add(resultSet.getString("COLUMN_NAME"));
    sets[3].add(resultSet.getString("FILTER"));
}

StringBuilder buf = new StringBuilder();
for (LinkedHashSet set : sets) {
    // append to buf all elements of each set
}