<form:form modelAttribute="encounter" method="post" class="form-horizontal" action="${actUrl}">
    <div class="control-group">
        <form:select path="codeSelected" items="${encountercodes}" size="5" style="min-width:600px"/>
    </div>
    <form:hidden path="id"/>
    <td>
    </td>
    <div class="form-actions">
        <button type="submit">Add a Billing Code</button> <h3>    Link to delete will go here.</h3>
    </div>
</form:form>