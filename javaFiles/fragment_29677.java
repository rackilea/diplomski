// in servlet class
@Override
public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException
{
    // this request object is actually your own AuthenticatedRequest wrapper
    int userId = req.getUserId();