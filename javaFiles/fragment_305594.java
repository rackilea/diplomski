int flag = 0;
while(rs.next())  {
    String userName2 = rs.getString("username");
    String passWord2 = rs.getString("password");
    String UserPass3 = userName2 + passWord2;

    if(UserPass1.equalsIgnoreCase(UserPass3)) {
        out.println("<br><br><br><b><i>Welcome " + UserPass3 + " to NetDesignAmerica!!</i></b>");
        flag = 1;
        break;
    }
}
if(flag == 0) {
    out.println("<br><br><br><b><i>Sorry " + UserPass1 + " didnt match any of our records</i></b>" );
}