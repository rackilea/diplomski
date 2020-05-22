while(cursor.isLast()){
   allNews[i] =  new News(Integer.parseInt(cursor.getString(0)),
                cursor.getString(1),cursor.getString(2));
   cursor.moveToNext();
   i++;
}