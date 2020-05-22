public static void main(String[] args) {
    String dbPath = "C:/Users/Public/JackcessTest.accdb";
    try (Database db = DatabaseBuilder.open(new File(dbPath))) {
        Table table = db.getTable("cmt_table");
        Cursor cursor = table.getDefaultCursor();
        cursor.beforeFirst();
        while (cursor.moveToNextRow()) {
            Row row = cursor.getCurrentRow();
            if (stringContainsSpecialValue(row.getString("cmt_data"))) {
                // handle matching row here
                System.out.println(row);
            }
        }
    } catch (Exception e) {
        e.printStackTrace(System.err);
    }
}

private static boolean stringContainsSpecialValue(String str) {
    boolean rtn = false;
    List<String> specialValues = Arrays.asList("MRSS0319", "TRPP3006");
    for (String val : specialValues) {
        if (str.contains(val)) {
            rtn = true;
            break;
        }
    }
    return rtn;
}