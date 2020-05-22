<form name="f" th:action="@{/login}" method="post">               
  <fieldset>

    <input type="hidden" 
           th:name="${_csrf.parameterName}" 
           th:value="${_csrf.token}" />

    ...
  </fieldset>
</form>