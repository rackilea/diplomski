email = request.getParameter("vemail");
if(email != null){
    String sql = "insert into regdriver(email)values ('"+email+"')";    
    st=con.createStatement();
    rs=st.executeQuery(sql);
}