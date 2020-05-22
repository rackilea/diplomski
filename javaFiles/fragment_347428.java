mCursor.moveToFirst();
do {
      //print all your columns:
      Log.d("Your class or activity","ID: +"mCursor.getString(c.getColumnIndex("ID"),"ETC:"+mCursor.getString(c.getColumnIndex("ETC"));

   } while (mCursor.moveToNext());