public void updateRows(String key, String value) {
    if (rows.containsKey(key))
        rows.put(key, value);
}

myList.stream().filter(x -> "TABLE1".equals(x.getTableName())).findAny()
                .ifPresent(d -> d.updateRows(key1, value1));