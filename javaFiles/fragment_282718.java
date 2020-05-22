<form:form
  action="${pageContext.request.contextPath}/ajouter_activite"
  method="post" commandName="combinedCommand"">

  ...
  <form:input type="text"path="activity.x"/>
  ...
  <form:input type="text"path="etabl.y"/>
  ...
</form:form>