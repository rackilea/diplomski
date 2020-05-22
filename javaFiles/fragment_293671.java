<% 
  if(request.getParameter("dicenum") != null) {
%>  

<% 
int num = Integer.parseInt(request.getParameter("dicenum")); 
if (num == 4)
    num = 1+(int)(Math.random()*4);
else if (num == 6)
    num = 1+(int)(Math.random()*6);
else if (num == 8)
    num = 1+(int)(Math.random()*8);
else if (num == 10)
    num = 1+(int)(Math.random()*10);
else if (num == 20)
    num = 1+(int)(Math.random()*20);
else
    num = 0;
%>
<%= (num == 0)? "The number you've entered is out of range.": num %>
<% } %>