<table>
    <tr jsfc="ui:repeat" value="#{dept.employees}" var="emp" class="#{emp.manager ? 'mngr' : 'peon'}">
       <td>#{emp.lastName}</td>
       <td>#{emp.firstName}</td>
    </tr>
</table>