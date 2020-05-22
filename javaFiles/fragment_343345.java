Cursor c = articlesDB.rawQuery("SELECT * FROM articles",null);
int articleIdIndex = c.getColumnIndex("articleId");
int urlIndex = c.getColumnIndex("url");
int titleIndex = c.getColumnIndex("title");

c.moveToFirst();
while (c!= null){
Log.i("articleIdIndex", Integer.toString(c.getInt(articleIdIndex)));
Log.i("articleUrl",c.getString(urlIndex) );
Log.i("titleTitle",c.getString(titleIndex));
c.moveToNext();
}