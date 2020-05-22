Login lg = new Login();
    for(int i=0; i <lgs.size(); i++){
     lg= lgs.get(i);
    if((user.equals(lg.getUsername()) && password.equals(lg.getPassword()) && type.equals("Administrator"))){
    session.setAttribute("name", lg.getFname() + " " + lg.getLname());
    session.setAttribute("type", lg.getUserType());
     response.sendRedirect("index.jsp");
 }else{

 }
}