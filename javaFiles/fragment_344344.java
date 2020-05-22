@Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,

        // ignore login page
        if (request.getServletPath() == "/index") { // BEWARE : to be adapted to your actual login page
            return true;
        }

        Users user=(Users) session.getAttribute("user");
        if(user == null)
        {
            System.err.println("Request Path : ");
            response.sendRedirect("index");
            return false;
        }
        else
        {
            return true;
        }
    }