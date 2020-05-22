//Pass java object as you do now
model.addAttribute("data",responseDTO);

//In JSP, include jstl taglib to help accessing List.
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script>
var errorArr = [], errorObj;
<c:forEach var="error" items="${data.errors}">
    errorObj = { errorName: '${error.errorName}' };
    errorArr.push(errorObj);                                  
</c:forEach>

//Populate the corresponding javascript object.
var data = {
  dataRequestName: '${data.dataRequestName}',
  actionPassed: ${data.actionPassed},
  errors: errorArr
};
</script>