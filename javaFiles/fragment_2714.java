<%-- iterate over the someList field of the someObject attribute --%>
<c:forEach var="outerItem" items="${someObject.someList}">
    <%-- now, outerItem is an attribute, and you may access its fields --%>

    <%-- iterate over the otherList field of the outerItem attribute --%>
    <c:forEach var="innerItem" items="${outerItem.otherList}">

        <%-- now, innerItem is an attribute, and you may access its fields --%>

    </c:forEach>

</c:forEach>