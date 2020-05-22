<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>create</title>
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <h1>Create User</h1>
        <br>
        <h2><a href='logout.jsp'>Log out</a></h2>
        <br>
        <h3><a href='success.jsp'>Go Back</a></h3>
        <form method="post" action="registration.jsp">
            <center>
            <table border="1" width="30%" cellpadding="3">
                <thead>
                    <tr>
                        <th colspan="2">Login Here</th>
                    </tr>
                </thead>
                <tbody>
                    <tr>
                        <td>User Name :</td>
                        <td><input type="text" name="uname" value="" /></td>
                    </tr>
                    <tr>
                        <td>User Id :</td>
                        <td><input type="text" name="uid" value="" /></td>
                    </tr>
                    <tr>
                        <td>Department :</td>
                        <td><select name="departments">
    <%try{
    String sql="select * from department";
    Class.forName("com.mysql.jdbc.Driver");
    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/login",
            "root", "root");
    Statement st = con.createStatement();
    ResultSet rs=st.executeQuery(sql);
    while(rs.next()){
    %>                          
      <option value="<%=rs.getInt("departmentid")%>"><%=rs.getString("departmentname")%></option>
<%}
    rs.close();
    st.close();
    con.close();
    }catch(Exception e){
    e.printStackTrace();
    }%>
                              </select></td>
                    </tr>
                    <tr>
                        <td>Email Id :</td>
                        <td><input type="text" name="email" value="" /></td>
                    </tr>
                    <tr>
                        <td>Mobile No. :</td>
                        <td><input type="text" name="mobile" value="" /></td>
                    </tr>
                    <tr>
                        <td>Password :</td>
                        <td><input type="password" name="pass" value="" /></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value="Login" /></td>
                        <td><input type="reset" value="Reset" /></td>
                    </tr>

                </tbody>
            </table>
            </center>
        </form>
     </body>
    </html>