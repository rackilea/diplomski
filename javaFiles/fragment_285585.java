viewCr=viewDb.rawQuery("SELECT * FROM CONTACTS",null);
if (viewCr != null) {
viewCr.moveToFirst(); 

     while(!viewCr.isAfterLast())
    {
      myTextView.append(viewCr.getString(viewCr.getColumnIndex("your_column_name")));
      //Your code...
      viewCr.moveNext();
    } 
    //close cursor here
   viewCr.close();
}