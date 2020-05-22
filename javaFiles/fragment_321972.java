<TABLE BORDER="1" CELLPADDING="3" CELLSPACING="1" style="text-align: center;">
<TR>
    <c:forEach var="h" items="${data.attributes}">
        <TH>${h.key}</TH>
    </c:forEach>
</TR>
//use jsp scriplets to acces both list simultaneoulsy
<% List data= request.getAttribute("data")==null?null:(List) request.getAttribute("data");
 List Names=data.get(0);
 List LastNames=data.get(1);
 for(int i=0;i<Names.length();i++){ %>
      <td><%=Names.get(i)%></td><td><%=LastNames.get(i)%></td>
 <%
      }

 %>