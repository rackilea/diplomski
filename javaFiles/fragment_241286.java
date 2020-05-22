// Java
dto.emailAddress = "the@email.address";
request.setAttribute("dto", dto);

<%-- JSP --%>
${dto.emailAddress}