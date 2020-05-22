<form:form method="POST" action="${flowExecutionUrl}&_eventId=next" modelAttribute="customerDto">
   <table>
    <tr>
        <td><form:label path="customer.name">Name</form:label></td>
        <td><form:input path="customer.name" /></td>
    </tr>
    <tr>
        <td><form:label path="customer.email">Email</form:label></td>
        <td><form:input path="customer.email" /></td>
    </tr>
    <tr>
        <td><form:label path="address.addressLine1">Address Line 1</form:label></td>
        <td><form:input path="address.addressLine1" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="Submit"/>
        </td>
    </tr>
   </table>
</form:form>