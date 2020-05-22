String query = "SELECT * FROM TableName WHERE 1=1"; 
if(a!=null)
    query+="AND a=?";
if(b!=null)
    query+="AND b=?";

PreparedStatement stmt ...