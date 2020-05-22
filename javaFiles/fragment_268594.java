<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
...
<c:set var="rawDate" value="${result.date}"/>
<c:set var="rawTime" value="${result.time}"/>
<c:out value="${fn:substring(rawDate,4,6)}"/>/<c:out value="${fn:substring(rawDate,6,8)}"/>
<c:out value="${fn:substring(rawtime,0,2)}"/>:<c:out value="${fn:substring(rawtime,2,4)}"/>