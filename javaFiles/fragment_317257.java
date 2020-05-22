CREATE FUNCTION countSessions(datamap map<text,int>,host text)  
RETURNS NULL ON NULL INPUT  
RETURNS map<text, int>  
LANGUAGE java as  
' 
Integer countValue = datamap.get(host); 
if(countValue == null) { 
countValue = 1; 
} else { 
countValue++; 
} 
datamap.put(host,countValue); 
return datamap; 
';