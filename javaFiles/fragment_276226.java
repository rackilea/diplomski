public ResultSet getEntry(String table, String[] ident){
try{
        stmt = conn.createStatement();
        String exec = "SELECT " + ident[0] + " FROM " + table;
        if(!ident[1].isEmpty()){
            exec += " WHERE(" + ident[1] + ");";
        }else{
            exec += ";";
        }
        ResultSet res = stmt.executeQuery(exec);
       /* while(res.next()){
            System.out.println(res.getInt("uid"));
            System.out.println(res.getString("uname"));
            System.out.println(res.getString("pwd"));
            System.out.println(res.getString("mail"));
            System.out.println(res.getInt("rank"));
            System.out.println(res.getInt("coins"));
            System.out.println(res.getString("stg"));
        }res.close();
        stmt.close();*/

return res;
    }catch(Exception e){
        e.printStackTrace();
    }
}