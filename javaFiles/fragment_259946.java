series2Strings = new String[cur.getCount()];
int k=0;
if(cur.moveToFirst()){
    while(!cur.isAfterLast()){

      Log.i("String", " "+ k + " " + cur.getString(1));
       series2Strings[k]=cur.getString(1);
        k++;
         cur.moveToNext();
       }
 }
 cur.close();