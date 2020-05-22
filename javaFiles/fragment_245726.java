String Key=null;

    if(request.getParameter("project")!=null){ 
        Key=request.getParameter("project").trim();
     }

if (AM == null) {
        response.sendRedirect("../portal/login.jsp?from=index.jsp&project="+Key);
    }