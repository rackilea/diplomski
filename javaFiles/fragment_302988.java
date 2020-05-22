<%
   Cookie cookie = null;
   Cookie[] cookies = null;
   cookies = request.getCookies();
    if( cookies != null)
      {
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
         String b = cookie.getComment();
     request.setAttribute("xyz", b);
     }
     }
%>