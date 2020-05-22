public  boolean validate(Login login)
{
  boolean status=true;
...
...
...
ResultSet rs=ps.executeQuery();

if (!rs.next()){
status=false;
}

return status;

}