HttpSession session =httpReg.getSession(false);
try
{
     if(session != null)
     { 
       Date date = new Date(session.getLastAccessedTime()); 
    }
}
catch( IllegalStateException ex )
{
      //comes here when session is invalid.
      // redirect to a clean error page "Your session has expired. Please login again."
}