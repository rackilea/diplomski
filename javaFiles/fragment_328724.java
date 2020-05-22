<c:if test="${pageContext.request.serverName ne 'demo.com' and pageContext.request.serverName ne 'sdemo.com'}">
    <%
        InetAddress ia = InetAddress.getLocalHost();
        String node = ia.getHostName();
        out.println("<!-- hostname  " + node+  " -->");
        pageContext.setAttribute("node", node);
    %>
    <div id="notProd"><spring:message code="nonproduction.environment.message" />
 <c:out value="${node}" />
</c:if>