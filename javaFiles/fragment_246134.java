<%@ taglib uri="/struts-tags" prefix="s" %>
<c:forEach items="${listaApprodi}" var="app">
    <tr>
       <td>
       <s:url action="your-ActionName" var="myurlvar" >
          <s:param name="app">${app.name}</s:param>
          <s:param name="lin">${requestScope.linea.name}</s:param>
       </s:url>
       <s:a href="%{myurlvar}">${app.name}</s:a>
       </td>
    </tr>
</c:forEach>