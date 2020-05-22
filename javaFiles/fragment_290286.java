<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<style type="text/css">
td {
    word-wrap: break-word;
}
</style>
</head>
<body>
<table width="100%" border="1" cellpadding="0" cellspacing="0"
    style="table-layout: fixed;">
    <colgroup>
        <col width="500">
    </colgroup>
    <tr>
        <th colspan="2">
        <h3>attributes in $paramValues</h3>
        </th>
    </tr>
    <c:forEach var="entry" items="${paramValues}">
        <tr>
            <td><c:out value="${entry.key}" /></td>
            <td><c:forEach var="item" items="${entry.value}"
                varStatus="status">
                <pre><c:out value="${item}" /></pre>
                <c:if test="${not status.last}">
                    <br />
                </c:if>
            </c:forEach></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="2">
        <h3>attributes in $requestScope</h3>
        </th>
    </tr>
    <c:forEach var="entry" items="${requestScope}">
        <tr>
            <td><c:out value="${entry.key}" /></td>
            <td><pre><c:out value="${entry.value}" /></pre></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="2">
        <h3>attributes in $sessionScope</h3>
        </th>
    </tr>
    <c:forEach var="entry" items="${sessionScope}">
        <tr>
            <td><c:out value="${entry.key}" /></td>
            <td><pre><c:out value="${entry.value}" /></pre></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="2">
        <h3>attributes in $pageScope</h3>
        </th>
    </tr>
    <c:forEach var="entry" items="${pageScope}">
        <tr>
            <td><c:out value="${entry.key}" /></td>
            <td><pre><c:out value="${entry.value}" /></pre></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="2">
        <h3>attributes in $headerValues</h3>
        </th>
    </tr>
    <c:forEach var="entry" items="${headerValues}">
        <tr>
            <td><c:out value="${entry.key}" /></td>
            <td><c:forEach var="item" items="${entry.value}"
                varStatus="status">
                <pre><c:out value="${item}" /></pre>
                <c:if test="${not status.last}">
                    <br />
                </c:if>
            </c:forEach></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="2">
        <h3>attributes in $applicationScope</h3>
        </th>
    </tr>
    <c:forEach var="entry" items="${applicationScope}">
        <tr>
            <td><c:out value="${entry.key}" /></td>
            <td><pre><c:out value="${entry.value}" /></pre></td>
        </tr>
    </c:forEach>
    <tr>
        <th colspan="2">
        <h3>System Properties</h3>
        </th>
    </tr>
    <tr>
        <th>Key</th>
        <th>Value</th>
    </tr>
    <%@page import="java.util.Map"%>
    <%@page import="java.util.Set"%>
    <%@page import="java.util.Properties"%>
    <%@page import="java.util.Arrays"%>
    <%
        Properties p = System.getProperties();
        Set<Map.Entry<Object, Object>> set = p.entrySet();
        for (Map.Entry<Object, Object> e : set) {
    %>
    <tr>
        <td><%=e.getKey()%></td>
        <td><%="".equals(e.getValue()) ? "&nbsp;" : e.getValue()%></td>
        <%
            }
        %>
    </tr>
    <tr>
        <th colspan="2">
        <h3>Spring Beans</h3>
        </th>
    </tr>
    <%@page import="org.springframework.web.context.WebApplicationContext"%>
    <%@page
        import="org.springframework.web.context.support.WebApplicationContextUtils"%>
    <%@page import="org.springframework.core.io.Resource"%>
    <%
        try {
            WebApplicationContext springContext = WebApplicationContextUtils
                    .getWebApplicationContext(config.getServletContext());
            if (springContext != null) {
                String[] beanNames = springContext.getBeanDefinitionNames();
                Arrays.sort(beanNames);
                for (String beanName : beanNames) {
                    String className = springContext.getType(beanName)
                            .getName();
    %>
    <tr>
        <td><%=beanName%></td>
        <td><%=className%></td>
    </tr>
    <%
        }
    %>
    <tr>
        <th colspan="2">
        <h3>Spring Resources</h3>
        </th>
    </tr>
    <tr>
        <th colspan="2">
        <form><input name="resources" size="50"/></form>
        </th>
    </tr>

    <%
        String resourceNames = request.getParameter("resources");
                if (resourceNames != null) {
                    Resource[] resources = springContext
                            .getResources(resourceNames);
                    for (Resource r : resources) {
    %>
    <tr>
        <td><%=r.getFilename()%></td>
        <td><%=r.getURI()%></td>
    </tr>
    <%
        }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>


</table>
</body>
</html>