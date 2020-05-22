<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
...
<fmt:parseNumber var="curPage" value="${param.curPage}" integerOnly="true" />
<fmt:parseNumber var="totalPages" value="${param.totalPages}" integerOnly="true" />
... 
<p>
  curPage: ${curPage}<br/>
  totalPages: ${totalPages}<br/>
  totalPages - curPage: ${totalPages - curPage}<br/>
  curPage gt totalPages: ${curPage >= totalPages}<br/>
</p>