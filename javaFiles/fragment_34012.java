HttpSession session =httpReg.getSession(false);
if( !request.isRequestedSessionIdValid() )
{
        //comes here when session is invalid.
        // redirect to a clean error page "Your session has expired. Please login again."
}