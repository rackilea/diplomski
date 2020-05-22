<%=out.print(idnum)%>
<%
    if (pwd.equals(password)) {
%>
    </br>Welcome 
    <form action="BuyTicket.jsp" method="post">
        <%=out.print(idnum)%>
        <input type="submit" text="Buy Tickets" />
    </form>

    </br>
<%
    } else {
%>
    </br>Invalid Username or Password please try one of the following
    </br>
    <a href="Login.html">Login</a>
    </br>
    <a href="Register.html">Register</a>
    </br>
<%
    }
%>