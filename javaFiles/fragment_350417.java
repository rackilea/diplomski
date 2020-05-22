<form method="POST" 
      enctype="multipart/form-data" 
      action="doUpload?${_csrf.parameterName}=${_csrf.token}">
      ...
      <input type="hidden" 
             name="${_csrf.parameterName}" 
             value="${_csrf.token}" />
</form>