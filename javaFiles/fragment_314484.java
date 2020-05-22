while(myList.size()!=0) 
{
  //get individual values in the array list
  int idx=0;
  String url= myList.remove(idx++).toString() ;
  String insert="INSERT into test (url) values (?)";
  prepstmt = conn.prepareStatement(insert);
  prepstmt .setString(r++, myURL);
 }