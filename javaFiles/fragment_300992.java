<%
ResultSet rs=null,rs1=null;

    String UserID = request.getParameter("UserID"); 
    String Password = request.getParameter("Password");
    session.setAttribute("UserID",UserID);
    int flag=0;
    try{    
        System.out.println("Validating..1");
        int Auth=1,flag1 = 0;

        String Query = "select * from login where UserID = '"+UserID+"' and Password='"+Password+"'";
        String Que = "select * from basicdetails where userid='"+UserID+"' and password='"+Password+"';";
        System.out.println(Que);
        rs = st.executeQuery(Query);
        int i=0;
        while(rs.next())
        {
            if(UserID.equals(rs.getString(1)) && Password.equals(rs.getString(2)))
            {
               Auth=rs.getInt(3);
               session.setAttribute("Auth",new Integer(Auth));
            }
            i++;
        }
        rs.close();

        if(i>0)
        {
         System.out.println("I " + i);
            if(Auth==1)
            {
                System.out.println("USER Verification");
            rs1= st.executeQuery(Que);
            System.out.println(rs1);
            rs1.next();
            String PhotoPath=rs1.getString(4);
            System.out.println("-------------------"+PhotoPath);
            session.setAttribute("PhotoPath",PhotoPath);
            %>
                <jsp:forward page="UserHome.jsp"/>
            <%
            }
            else if(Auth==0)
            {
            %>
                <jsp:forward page="AdminMenu.jsp"/>
            <%
            }
        }
        else
        {
            %>
            <jsp:forward page="Login.jsp"/>
            <%
        }        
        st.close();
        con.close();
    }
    catch(Exception e)
    {
    %>
      <%=e%>
    <% } %>