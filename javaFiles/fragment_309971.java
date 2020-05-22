Resultset rs=null; //declare a local variable
try {
    //wrong code get the query from the request parameter! 
    // rs = db.getResultSet(request.getParameter("query"));
    String query="select col from table where a='b'"; // whatever
    rs = db.getResultSet(query);
    //just one value? no need of while
    if(rs.next()){
        MyBean bean=new MyBean();
        bean.setName(rs.getString(1));
        bean.setSurname(rs.getString(2));
        //here is where you put your bean to the request
        request.setAttribute("myBean", bean);
    }
} catch (SQLException e) {
    e.printStackTrace();
} finally {
    //Don't forget closing your Rs
    if(rs!=null) {rs.close();}
}