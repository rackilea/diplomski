public static String login(UserBean bean) {
String role = "";
//one query is enough to get the role based on user name and password

String userlogin =
               "select role from users where username='"
                        + username
                        + "' AND password='"
                        + password;

//execute your query
----------------------------------
if(rs2.next())
role = rs2.getString(1);//role either A for admin or U for user
//catch the exceptions
------------------------------------

return role;
}