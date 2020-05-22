<%
        ErrorDAO daoaut=new ErrorDAO();
        List<ErrorENT> list=daoaut.list();            
    %>
    <table BORDER="3">
        <tr>
            <td>ID</td><td>DATE</td><td>LOG</td><td>ESTATE</td><td> </td>
        </tr>
        <% for(ErrorENT aut:list){ %>

        <tr>
            <td> <%= aut.getIdError()%> </td>
            <td> <%= aut.getDate()%> </td>
            <td> <%= aut.getLog() %> </td>
            <td> <%= aut.isEstate() %> </td>
            <td> <a href="your page name?id=<%=aut.getIdError()%>"><input type="button" id="btnUpdate" value="Update"/> </a></td>
        </tr>
    </form>
        <% } %>
    </table>