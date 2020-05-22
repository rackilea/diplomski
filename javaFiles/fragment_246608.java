<%
    String str = rs.getString(6);
    if (str == null) {
 %>
               <td>  <select name="Type" id="Type">
                    <option value="" disabled selected>Select your option</option>
                    <option value="Looseleaf - Update">Looseleaf - Update</option>
                    <option value="Pamphlet">Pamphlet</option>
                </select>
                 </td>
<%
    } else {
%>
               <td>
<%=str%> 
               </td>
<%
    }
%>