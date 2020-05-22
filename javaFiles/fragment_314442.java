<table>
   <% 
   for(int i=0; i < extcteachList.size(); i++) {
   %>           
      <tr>
        <td> <%= extcteachList.get(i).getAttr1() %>  </td>
        <td> <%= extcteachList.get(i).getAttr1() %>  </td>  
      <tr>
   <%
   }
   %>
</table>