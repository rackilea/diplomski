Response.Write(@"
<html><body>
<table>
");try{
while( rs.next() ){
Response.Write(@"<tr>
<td>"); Response.Write(rs.getString("id")); Response.Write(@"</td>
<td>"); Response.Write(rs.getString("date")); Response.Write(@"</td>
<td>"); Response.Write(rs.getString("date")); Response.Write(@"</td>
</tr>
");}Response.Write(@"
");}
catch(Exception e){e.printStackTrace();}
finally{
if(con!=null) con.close();
}
Response.Write(@"
</body></html>");