<%@ page contentType="text/html; charset=iso-8859-1" language="java" %>
<%
    String category = request.getParameter("category");
    List<String> subCategories = Categories.getSubCategories(category);
%>
<html>
<body>
//Print the sub-categories
Subcategories are : <%=subCategories%>
</body>