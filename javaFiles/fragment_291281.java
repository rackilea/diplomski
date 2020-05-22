<s:if test="%{list!=null"}>
<s:iterator  value="list"> 
         <tr>
                <td><s:property value="Code"/></td>  
                <td><s:property value="Name"/></td> 
                <td><s:property value="Continent"/></td> 
                <td><s:property value="IndepYear"/></td> 
                <td><s:property value="HeadOfState"/></td> 
                <td><s:property value="Capital"/></td> 
                <td><s:property value="editedbyuser"/></td> 
                <td><s:property value="editdatetime"/></td> 
                <td>
                    <s:a action="editworld">
                        edit<s:param name="Code" value="Code"/>
                    </s:a>
                </td>
            <tr>
          </s:iterator> 
</s:if>