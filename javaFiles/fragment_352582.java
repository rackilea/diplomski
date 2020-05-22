String [] ids = list.split(",");
String sql = "{call yourProcedure(";
for(int i = 0; i < ids.length; i++)
    sql +=  (i == 0?"":",") + "?";
sql += ")}";
CallableStatement cst = con.prepareCall(sql);
for(int i = 0; i < ids.length; i++)
    cst.setInt(i+1, Integer.parseInt(ids[i]));