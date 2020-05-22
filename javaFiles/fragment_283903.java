while(rs.next())
{ 
  // get the XMLType 
 XMLType poxml = (XMLType)rs.getObject(1); 

   // get the XML as a string...
 String poString = poxml.getStringVal();
 }