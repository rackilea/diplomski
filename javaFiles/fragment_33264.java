<%
List<Obiekt> list = new Wypelnij().getObiekty();
%>
<select>
<%
for(Obiekt obiekt : list){
%>
<option value="1" ><%=obiekt.getNazwa()%><option/>
<% } %>
</select>