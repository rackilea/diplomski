public View newView (Context context, Cursor cursor, ViewGroup parent){
      long id = cursor.getLong(TodoDbAdapter.ROW_ID_COLUMN);
      LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
      if (existAlarm(id)){
           return inflater.inflate(R.layout.todo_row_green, null);
      } else {
           return inflater.inflate(R.layout.todo_row, null);
      }
 }