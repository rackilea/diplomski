if(request.getParameter("submit") != null){ 

    if(request.getParameter("submit").equals("add"))
        isum += inumber;
    else if(request.getParameter("submit").equals("subtract"))
        isum -= inumber;
    session.setAttribute("sum",""+isum);
}