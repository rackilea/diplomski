if (req.getRequestURI().indexOf("Login.jsp") != -1 || req.getRequestURI().indexOf("LoginE.jsp") != -1) {
    if (user != null) {
        response.sendRedirect("already-logged-in.jsp");
        return;
    }
}