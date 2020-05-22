jsp code

<style>
    h1{background-color:orange;color:white;}
    body{background-color:lightblue}
</style>
    </head>
<body>
<h1>SIGNUP</h1>
<%
    String user_name = request.getParameter("u_name");
        String user_email = request.getParameter("u_email");
        String user_pass = request.getParameter("u_pass");
    Class.forName("org.postgresql.Driver"); 
try{
Connection conn=DriverManager.getConnection("jdbc:postgresql://localhost:5434/mydb","postgres","admin"); 
 
PreparedStatement ps;
  ps=conn.prepareStatement("insert into public.registration values(?,?,?)");
 
        ps.setString(1, user_name);
        ps.setString(2, user_email);
        ps.setString(3, user_pass);
        int i=ps.executeUpdate();
        
          if(i>0)
          {
            out.println("You are sucessfully registered");
          }else{
   out.println("Failed in  registration");
   }
       
        }
        catch(Exception se)
        {
            se.printStackTrace();
        }

%>
</body>
</html>