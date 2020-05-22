String selectQuery = "select city from BranchNetwork";
    Cursor cursor = database.rawQuery(selectQuery, null);
    List <String> branches = new ArrayList<String>();
    String str=null;
    cursor.moveToFirst();
        do
       {
         str= m_cursor.getString(m_cursor.getColumnIndex("city"));
          branches.add(str);
       }
        while(cursor.moveToNext());
        Toast.makeText(context, "Data Retrieved: "+branches.get(1), Toast.LENGTH_LONG).show();
    }
        return branches;