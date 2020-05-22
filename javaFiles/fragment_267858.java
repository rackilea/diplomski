String[] hospFields = new String[adapter.getCount()];
for (int i = 0; i < adapter.getCount(); i++) {
    HashMap<String, String> rowData = adapter.getItem(i); //gets HashMap of a specific row
    String name = rowData.get("name"); //gets the field name of that row
    hospFields[i] = name; // copies field into your array
}