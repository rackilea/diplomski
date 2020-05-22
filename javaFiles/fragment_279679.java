String id = "";
if (res.moveToFirst()){
    id = res.getString(cursor.getColumnIndex(0));
}
if (id.isEmpty())
    return;