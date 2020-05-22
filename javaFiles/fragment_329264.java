Cursor cursor = dbHelper.readBook(Integer.toString(position));
StringBuilder sb = new StringBuilder();

while (cursor.moveToNext()) {

    sb.append(cursor.getString(4));
    sb.append("\n");

    Intent i = new Intent(MainActivity2Activity.this,
                               Books.class);
         i.putExtra(null, sb.toString());
         startActivity(i);    
 }