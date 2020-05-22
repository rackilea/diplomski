if (list.contains(user))
        return true;
    else
    {
        //set up the view
        response.sendRedirect("nope_view");
        return false;
    }