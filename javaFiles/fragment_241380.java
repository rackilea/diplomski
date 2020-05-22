// get the session
HttpSession session = request.getSession();

// get object from session
NewFileThing fi =  (NewFileThing) session.getAttribute("NewFileThing");

// Make sure it is on the session
if (fi != null)
{
    String name = fi.getName();
}