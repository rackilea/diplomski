<c:choose>
    <c:when test= "${request.getSession().getAttribute("userName").equals("Guest")}">
        <div> Welcome Guest</div>
    </c:when>
    <c:otherwise>
        <div> Welcome Real User</div>
    </c:otherwise>
</c:choose>