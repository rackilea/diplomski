List<Integer> codes = new ArrayList<Integer>();
// ...
resultSet = statement.executeQuery();
while (resultSet.next()) {
    codes.add(resultSet.getInt("Code"));
}
// ...