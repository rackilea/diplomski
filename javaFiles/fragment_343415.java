// class to represent your rows
class Row {
    int definitionId;
    int position;
    int parent;
}

// map of parents to list of their rows
Map<Integer, List<Row>> parentMap = new HashMap<Integer, List<Row>>();

// iterate over all results, build row objects and populate the map
while (rs.next()) {
    Row row = new Row();
    row.definitionId = rs.getInt("definition_id");
    row.position = rs.getInt("position");
    row.parent = rs.getInt("parent");

    // find the list of rows for the parent, create it if it doesn't exist
    List<Row> rows = parentMap.get(row.parent);
    if (rows == null) {
        rows = new ArrayList<Row>();
        parentMap.put(row.parent, rows);
    }

    // add row to the list for its parent
    rows.add(row);
}

// find all rows for parent == 7
for (Row row : parentMap.get(7)) {
    // process row
}