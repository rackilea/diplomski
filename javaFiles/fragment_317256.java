CREATE FUNCTION countSessions("dataMap" map<text,int>,host text)  
RETURNS NULL ON NULL INPUT  
RETURNS map<text, int>  
LANGUAGE java as  
' 
Integer countValue = dataMap.get(host); 
if(countValue == null) { 
countValue = 1; 
} else { 
countValue++; 
} 
dataMap.put(host,countValue); 
return dataMap; 
';