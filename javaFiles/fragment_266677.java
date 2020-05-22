listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

            if(cursor.getCount()>0){
                cursor.moveToPosition(i);
                Intent intent = new Intent(MainActivity.this, EditData.class);
                intent.putExtra("Location", cursor.getString(cursor.getColumnIndex(DBHelper.LOCATION))));
                intent.putExtra("Date", cursor.getString(cursor.getColumnIndex(DBHelper.DATE))));
                intent.putExtra("Not_at_homes", cursor.getString(cursor.getColumnIndex(DBHelper.NOTES))));
                startActivity(intent);
            }

        }
    });