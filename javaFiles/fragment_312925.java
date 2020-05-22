<%
    String status = "offline"; // declare the variable outside the if else
    if (request.getSession().getAttribute("user") != null) {
        status = "online"; // if the condition is correct then assign "online"
    }
%>