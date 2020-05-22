RequestDispatcher dispatcher;
String username = request.getParameter("username");
String passwd = request.getParameter("passwd");
String destination = "";//new targe variable
if(username != null && passwd != null){
    try{
        Database database = new Database("com.mysql.jdbc.Driver",
                "jdbc:mysql://localhost:3306/picshow","root","000000");
        ResultSet rs = database.query("select * from ps_user where name=?", username);
        if(rs.next()){
            if(rs.getString("passwd").equals(passwd)){
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                System.out.println("login successful");
                destination=request.getContextPath()+"/personalpage.jsp";//set your target
            }else {
                errMsg = "invalid password";
            }
        }else {
            errMsg="user not exist";
        }
    }catch(Exception e){
        e.printStackTrace();
    }
    if(errMsg != null && !errMsg.equals("")){
        destination=request.getContextPath()+"/login.jsp";//set your target
        request.setAttribute("errMsg", errMsg);
    }
}else {
    destination=request.getRequestDispatcher(request.getContextPath()+"/login.jsp");//set 
}

dispatcher = request.getRequestDispatcher(destination);
dispatcher.forward(request, response);