String query="select case when exists 
(select * from [entry] 
where title='Hanim') 
then cast (1 as bit) else cast (0 as bit) end
as [result]"
Cursor cursor=mdb.rawQuery(query,null);
int cIX=cursor.getColumnIndex("result");
data=cursor.getString(cIX);