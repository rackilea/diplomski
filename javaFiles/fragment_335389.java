<% if (isAliveMessage=="TIVOLI ALARM") {%>
<FONT COLOR="Red">
<p><b>Status of Alarm:<%= isAliveMessage  %></b></p>
</FONT>
<% } else { %>
<p><b>Status of Alarm:<%= isAliveMessage %></b></p>
<% } %>