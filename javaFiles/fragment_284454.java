<table>
<s:iterator value="ListOfpersons" status="status">
<tr>
   <td><s:textfield name="ListOfpersons[%{#status.index}].firstname"/></td>
   <td><s:textfield name="ListOfpersons[%{#status.index}].lastname"/></td>
   <td><s:textfield name="ListOfpersons[%{#status.index}].age"/></td>
   <td><s:textfield name="ListOfpersons[%{#status.index}].sex"/></td>
</tr>
</s:iterator>
</table>