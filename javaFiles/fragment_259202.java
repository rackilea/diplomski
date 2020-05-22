<spring:bind path="task.dueDate">
<div class="control-group${(not empty status.errorMessage) ? ' error':''}">
</spring:bind>
    <form:label cssClass="control-label" path="dueDate" cssErrorClass="inputError">Due date</form:label>
    <div class="controls">
        <form:input path="dueDate"/>
        <span class="help-block"><form:errors path="dueDate" /></span>
    </div>
</div>