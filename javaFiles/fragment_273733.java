<body>
    <% 

           if(storeusr.validateUser(request.getRemoteUser()))  
          response.sendRedirect("ListProjects.jsp");   


    %>