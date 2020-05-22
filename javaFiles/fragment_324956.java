HttpSession session = request.getSession(false); // Will not create a new session.
if(session!=null)
{
   session.invalidate();
}
session = request.getSession(true);