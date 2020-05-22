int idx=0;
while(idx < myList.size()) 
{
  String url= myList.get(idx).toString() ;
  String insert="INSERT into test (url) values (?)";
  prepstmt = conn.prepareStatement(insert);
  prepstmt .setString(r++, myURL);
  idx++;
 }