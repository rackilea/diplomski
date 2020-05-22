<%
String path = pageContext.getServletContext().getRealPath("/");
Collection<String> paths = new ArrayList<String>();
for (File file : FileUtils.listFiles(new File(path), new String[] { "ext" }, true)) {
    //Make the path relative
    paths.add(file.getAbsolutePath().substring(path.length()));
}
%>
<c:forEach items="<%=paths%>" var="path">
    <jsp:include page="../${path}"/>
</c:forEach>