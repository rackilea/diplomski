listView.setOnItemClickListener(new OnItemClickListener() {
    @Override public void onItemClick(AdapterView<?> adapter, View view, int pos, long id) {
        Intent intent = new Intent(this, EmployeeDetails.class);
        Cursor cursor = (Cursor) adapter.getItem(pos);
        intent.putExtra("EMPLOYEE_ID", cursor.getInt(cursor.getColumnIndex("_id")));
        startActivity(intent);                
    }
});