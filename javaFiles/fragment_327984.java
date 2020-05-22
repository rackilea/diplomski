Collections.reverse(ID_Array);
Collections.reverse(NAME_Array);
Collections.reverse(PHONE_NUMBER_Array);
listAdapter = new ListAdapter(DisplaySQLiteDataActivity.this,    
                ID_Array,
                NAME_Array,
                PHONE_NUMBER_Array
        );    
LISTVIEW.setAdapter(listAdapter);