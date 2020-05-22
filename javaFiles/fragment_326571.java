public String[][] customQuery(String query) {
    Cursor cur = null;
    try {
        cur = db.rawQuery(query,null);
    } catch(SQLException e) {
        Log.d("DATABASE", e.toString());
    }

    String data[][] = new String[cur.getCount()][cur.getColumnCount()];

    if (cur != null) {
        int i = 0;
        while (cur.moveToNext()) {
            int j = 0;
            while (j < cur.getColumnCount()) {
                data[i][j] = cur.getString(j);
                j++;
            }
            i++;
            cur.moveToNext();
        }
        cur.close();
    }
    return data;
}