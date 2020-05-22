<%
String cookieName = "username";
Cookie cookies [] = request.getCookies ();
Cookie myCookie = null;
if (cookies != null){
  for (int i = 0; i < cookies.length; i++) {
    if (cookies [i].getName().equals (cookieName)){
      myCookie = cookies[i];
      break;
    }
  }
}
%>