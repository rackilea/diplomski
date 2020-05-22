<%
   String path = request.getPathInfo();
   if (path == null || "".equalsIgnoreCase(path)) {
      // The path was empty, display the current user's profile
   } else {
      // Display the named profile
   }
%>