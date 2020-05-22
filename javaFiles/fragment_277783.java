Cursor c = db.rawQuery("SELECT * FROM BOOKMARKS", null);

ID = c.getColumnIndex("ID");

            audiotime=c.getColumnIndex("BookmarkTime");
            // Check result.
            c.moveToFirst();
            if (c != null) 
            {
                // Loop through all Results
                do 
                {
                    /*String str=c.getString(ID);
                    audiobooks.add(str);*/
                    str=c.getString(audiotime);
                    audiobooks.add(str);
}
                while(c.moveToNext());

                c.close();
                db.close();

                //TODO
                arrayAdapter=new ArrayAdapter<String>(this,  R.layout.row3, R.id.itemr1,audiobooks);
                lv.setAdapter(arrayAdapter);
cursor.close();
        db.close(); //close db resources
}
public void onClick(View v) 
{
if(v.getId()==R.id.Delete)
{

db = openOrCreateDatabase("DB", 0, null);
db.delete("BOOKMARKS", null, null);

int j=lv.getCount();
                Toast.makeText(GetAudioBookmarks.this, " after delete listview count  " +j,Toast.LENGTH_SHORT).show();



}