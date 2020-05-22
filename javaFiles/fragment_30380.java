public class TableData {
    public String mColumn1;
    public String mColumn2;
    public String mColumn3;
    public String mColumn4;
    public String mColumn5;
}

public ArrayList<TableData> getCursorData(Cursor cursor) {

    ArrayList<TableData> resultList = new ArrayList();

    if(cursor.moveToFirst()){
        do{
            TableData row = new TableData();
            row.mColumn1 = Cursor.getString("column1");
            row.mColumn2 = Cursor.getString("column2");
            row.mColumn3 = Cursor.getString("column3");
            ...
            resultList.add(row);
        } while(cursor.moveToNext());
    }

    return resultList;
}