<%
Enumeration en = request.getAttributeNames();
while(en.hasMoreElements()) {
    String attr = (String)en.nextElement();
    if(attr.startsWith("org.springframework.validation.BindingResult")) {
        %>
        <spring:hasBindErrors name='<%= attr.substring(attr.lastIndexOf(".")+1) %>' >
            <div class="error_box">
                <c:forEach var="error" items="${errors.allErrors}">
                    <spring:message message="${error}"></spring:message>
                    <br />
                </c:forEach>
            </div>
        </spring:hasBindErrors>
        <% 
    }
}
%>