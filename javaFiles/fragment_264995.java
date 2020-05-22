protected abstract String[] getColumnNames();

public HashMap<Integer, String> getColumns() {
    HashMap<Integer, String> columnsMap = new HashMap<>();
    String[] columns = this.getColumnNames(); 
    for (int i = 0; i < columns.length; i++) {
         columnsMap.put(i + 1, columns[i]);
    }
return columnsMap;