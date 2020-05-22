String mStr="";

mStr=mStr.concat("<body >");
mStr=mStr.concat("<tr><td align='center'><b>orderno</b></td><td align='center'><b>productid</b></td><td align='center'><b>productqty</b></td>
<td align='center'><b>custid</b></td></tr>");

dbadapter.open();
Cursor cursor=dbadapter.fetchordersdata(custid);
cursor.moveToFirst();
while(!cursor.isAfterLast())
            {
mStr=mStr.concat("<tr><td>"+(cursor.getString(cursor.getColumnIndex("col1")))+"</td><td>"+(cursor.getString(cursor.getColumnIndex("col2")))+"</td>
<td>"+(cursor.getString(cursor.getColumnIndex("col3")))+"</td>
<td>"+(cursor.getString(cursor.getColumnIndex("col4")))+"</td></tr>");


  cursor.moveToNext();
}

   mStr.concat("</table></body>");