response.sendRedirect("Admin.jsp");
return false;

// in the doGet method
if (!Utils.CheckSession(request,response)) {
    return;
}