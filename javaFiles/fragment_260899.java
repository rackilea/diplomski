<%@tag description="xml parser" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@attribute name="messageUrl"%>
<c:import url="${messageUrl}" var="message" />
<x:parse var="a" doc="${message}" />
<x:forEach var="current" select="$a/people/person">
    <ul>
        <li>
            Name <x:out select="$current/@name" /> age <x:out select="$current/@age" />
        </li>
    </ul>
</x:forEach>