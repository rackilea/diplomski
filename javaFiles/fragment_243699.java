List<List<String>> result = new ArrayList<>();  // List of list, one per row
...
while (resultset.next()) {
    List<String> row = new ArrayList<>(numcols); // new list per row
    int i = 1;
    while (i <= numcols) {  // don't skip the last column, use <=
        row.add(resultset.getString(i++));
    }
    result.add(row); // add it to the result
}