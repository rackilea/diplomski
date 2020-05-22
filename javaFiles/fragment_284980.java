<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script
  src="https://code.jquery.com/jquery-2.2.4.min.js"></script>
</head>

<% List<String> strList = new ArrayList<String>();
strList.add("one");
strList.add("two");
strList.add("three"); %>

<script type="text/javascript">

$(document).ready(function() {
    var notes = new Array();
    <%
    for(String note:strList){
    %>
    notes.push('<%=note%>');
    <%}%>
    alert(notes);
});
</script>
<body>

</body>
</html>