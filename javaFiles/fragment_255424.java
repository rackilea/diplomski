private void insert(MenuItem item) {
    AdapterContextMenuInfo info = (AdapterContextMenuInfo) item
            .getMenuInfo();
    Intent insertData = new Intent(Lab8_082588.this,
            Lab8_082588Insert.class);
    insertData.put("CURRENT_ROW", info.position);// there is no need for extra data, you're going to insert it anyway
    startActivityForResult(insertData, Lab8_082588.INSERT_MOVIE);
}