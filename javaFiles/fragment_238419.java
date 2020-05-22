<c:if test="${not pageContext.session['new']}">
    <p>You've already visited this site before.</p>
</c:if>
<c:if test="${pageContext.session['new']}">
    <p>You've just started the session with this request!</p>
</c:if>