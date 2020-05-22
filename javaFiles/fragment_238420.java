<c:if test="${not empty user}">
    <p>You're still logged in.</p>
</c:if>
<c:if test="${empty user}">
    <p>You're not logged in!</p>
</c:if>