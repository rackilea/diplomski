<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="s" uri="/struts-tags"%> 
<html>
    <head>
        <title> ${pageTitle}</title>
    </head>

    <body>
        <c:import url="${page}.jsp" />
    </body>
</html>