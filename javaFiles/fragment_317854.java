String columns = "";
String values = "";

for (int i = 0; i <= result.size(); i++) {
   columns += "VALUE" + (i+1) +",";
   values+="?,";
}

// get rid of trailing ,
columns = b.replace(columns.lastIndexOf(","), columns.lastIndexOf(",") + 1,""); 
values = b.replace(values.lastIndexOf(","), values.lastIndexOf(",") + 1,"");

String myQuery = "INSERT INTO TB_BS_VALUE ("+columns+") VALUES ("+values+")"; 

pstmt = new PreparedStatementLogable(myConn, myQuery);

for (int i = 0; i <= result.size(); i++) {
    pstmt.setString(i, result[i]);
}