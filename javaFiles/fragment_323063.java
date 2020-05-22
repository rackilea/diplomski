SimpleCursorAdapter notes = new SimpleCursorAdapter(this, 
                R.layout.notes_row, c, from, to); 

    notes.setViewBinder(new SimpleCursorAdapter.ViewBinder() { 

public boolean setViewValue(View view, Cursor cursor, int column) 
{ 
TextView tv = (TextView) view; 
view.setTag=cursor.getInt(cursor.getColumnIndex ("_id")); // You need to include the _id in the query
tv.setText(String.Valueof(cursor.getInt(cursor.getColumnIndex (NotesDbAdapter.KEY_TITLE ))));
return true; 
} 
});

         lv.setOnItemClickListener(new OnItemClickListener() { 

         public void onItemClick(AdapterView<?> parent, View view, 
         int position, long id) { 

         TextView tv=(TextView) view;
     String ID=view.getTag();
    // Delete ID from the DB
    notes.notifyDataSetChanged(); 

         }; 

         });    
    setListAdapter(notes); 


    } 
}