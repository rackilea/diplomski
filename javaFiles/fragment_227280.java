<div class="error" 
     th:if="${param.login_error}"
     th:with="errorMsg=${session["SPRING_SECURITY_LAST_EXCEPTION"].message}">
  Your login attempt was not successful, try again.<br />
  Reason: <span th:text="${errorMsg}">Wrong input!</span> 
</div>