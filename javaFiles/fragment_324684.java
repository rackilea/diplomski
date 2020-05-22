if(session.getAttribute("user")!=null)
{
    User user=(User)session.getAttribute("user");

}
else 
{
   out.print("Log in please");

 }