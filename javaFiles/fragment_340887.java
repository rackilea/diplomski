public void populateSheet2 (HashMap<String, String> map, Sheet sheet2){
    for (Row row : sheet2){
        String id = row.getCell(1).getValueAsString();
        String data = map.get(id);
        row.createCell(2).setValue(data);
    }
}