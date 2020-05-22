try (PrintWriter out = response.getWriter()) 
{
    request.getRequestDispatcher("link.html").include(request, response);
    String u = null;
    Cookie cookies[] = request.getCookies();
    Boolean blnFoundSpecialCookieWithValue = false; //initialize to false
    for (Cookie cookie : cookies) 
    {
        if ((cookie.getName()).equals("special")) 
        {
            String name = cookie.getValue();
            if (!name.equals(u)) 
            {
                blnFoundSpecialCookieWithValue = true; //set boolean
                out.print("<b>Welcome to Profile</b>");
                out.print("<br>Welcome, " + name);
            }
        }
    }
    //use boolean here to minimize number of else blocks needed
    //and not have to repeat the out.print()s
    if(!blnFoundSpecialCookieWithValue)
    {
        out.print(" LogIn First ");
        request.getRequestDispatcher("login.html").include(request, response);
    }
}