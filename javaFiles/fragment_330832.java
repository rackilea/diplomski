protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        PrintWriter out=response.getWriter();
        try{
        DataBaseConnection db=new DataBaseConnection();
        java.sql.Connection con= db.connet();
        //...... 
       //Statement st=con.createStatement(); // This may be the root cause of exception
       // check null here
      if(con!=null){
        // create statement or prepared statement
      }  
}