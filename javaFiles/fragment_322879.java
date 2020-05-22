String user = req.getParameter("username");
String pass = req.getParameter("password");

Connection con = null;

try {
    con = ConexaoFactory.getInst().getConnection("", "");       

    User user = BOClass.search(user, pass, con);

    if(user == null){
        //not found;
    }else{
        //found;
    }
} catch (Exception e) {         
    e.printStackTrace();
}finally {          
    try {               
        if(con != null)
            con.close();
    } catch (Exception e2) {
        e2.printStackTrace();
    }
}