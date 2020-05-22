<%
  Cookie[] my = request.getCookies();
  for(int i=0;i<my.length;i++){
  if(my.getName()=="thecookie"){
  String filetext = my[i].getValue().toString();
   }
  }
%>

<div id="editor"><%=filetext %></div>