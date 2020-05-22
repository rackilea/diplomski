<%
  String value=request.getParameter("student_id");;
  int v=Integer.parseInt(value);
  Class.forName("com.mysql.jdbc.Driver");
  Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root", "welcome");
  Statement st=conn.createStatement();
  ResultSet rs = st.executeQuery("select * from student where student_id='"+v+"'");
  if(rs.next()){
      %>
  <tr><td>Name: </td><td><input type="text" value="<%=rs.getString("student_name")%>"/> </td></tr>
        <%
  }
  %>