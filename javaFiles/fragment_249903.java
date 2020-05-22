<tr><td><select name="selBaseCurr">
<%
while ( ! rs.next()) {
    if (fEmptyRecordset){
        break;
    }
    if (! fFirstPass){
        rs.next(); //originally rs.getString;
    } else {
        fFirstPass = false;
    }
    if (rs.getString) {
        break;
    }
    if ( ! rs.getString("BASE_CURR_CODE").equals("")){
   %>
        <option value="<%=rs.getString("BLMBG_CURR_CODE")%>" 
                <%if (rs.getString("BLMBG_CURR_CODE").trim()) eq        
                    (request.getParameter("selBaseCurr").trim());%>
                    selected="true"
                <%}%>>
        <%=rs.getString("BLMBG_CURR_NAME")%>&nbsp;
        (<%=rs.getString("BLMBG_CURR_CODE")%>)</option>
<%
    }

//    }        This one is extra in your code!!

fFirstPass = true;
if (! fEmptyRecordset)
{
    rs.next();//originally rs.getString;
}
%>

     </select>
</td></tr>