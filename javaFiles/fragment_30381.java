private String[][] data;

public void getCursorData(Cursor cursor) {
    if (cursor.moveToFirst()) {
        data = new String[cursor.getCount()][]; // You have to instantiate your bi-dimensional array
        int i = 0;
        do {
            data[i] = new String[cursor.getColumnCount()];
            for (int f = 0; f < cursor.getColumnCount(); f++) {
                data[i][f] = cursor.getString(f);
            }
            i++;
        } while (cursor.moveToNext());
    }
}