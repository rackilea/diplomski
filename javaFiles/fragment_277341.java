Pattern p = Pattern.compile("/\<TD class=MoreB align=center>(.*)\<\/td\>/"); 
Matcher m = p.matcher(str); 
while(m.find()) { 

  //do whatever you want here
 }