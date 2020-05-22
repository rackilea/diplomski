for(int i=0;i<z;i++){

int ID = yourCursor.getInt(0);

if(ID==YOUR_NEEDED_ID){

  int percantage = yourCursor.getInt(2);
   break; //if you got what you want, cursor could be stopped
 }

 yourCursor.moveToNext();

}