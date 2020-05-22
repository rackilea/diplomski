<%
        ArrayList<Integer> values= (ArrayList) request.getAttribute("valuesarray");
   %>
        <table>
    <%
    int k=0;
    int noOfRows=5;
    int noOftds=4;
    for(int i = 0; i<noOfRows; i++)

            {
        if(k==values.size()){break;}
        %>
                <tr>
                <%for(int j = 0; j<noOftds; j++){%>
                 <td><%=values.get(k) %></td>
                 <%k++%>
    <%          
    }%>
            </tr>
    <%          } %>
    </table>