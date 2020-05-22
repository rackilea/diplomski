Map<String, List<Row>> mappedValues = new HashMap<>();
for(Row row : data) {
    if(mappedValues.containsKey(row.id) {
        List<Row> values = mappedValues.get(row.id)
        values.add(row)
    }
    else {
        List<Row> newValues = new ArrayList<>();
        newValues.add(row)
        mappedValues.put(row.id, newValues);
    }
}