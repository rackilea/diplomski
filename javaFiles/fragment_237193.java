String sqlInsert= "INSERT INTO " + "'"+name+"' (Type,Text,OtherFormats ,Date,Image,RealName )VALUES     
("+"'"+ID+"'"+","+"'"+Type+"'"+","+"'"+Text+"'"+","+
"'"+OtherFormats+"'"+","+"'"+Date+"'"+"  
,"+"'"+Image+"'"+","+"'"+RealName+"')"; 

db.execSQL(sqlInsert);