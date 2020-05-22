<%
    DriverSearchResult dSR = new DriverSearchResult(); // <- you create a new object

    %>
    <table>
    <th>ID</th>
    <tr>
    <td><%=dSR.getId() %></td> <!-- <-- you print its id which is 0 -->
    </tr>
    <th>Name</th>
    <tr>
    <td><%=dSR.getName() %></td> <!-- <-- you print its name which is null -->
    </tr>