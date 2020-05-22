<c:set var="someproperty">
    <str:substring start="${USERINFO.someproperty.length-2}" end="2">The tree is green.</str:substring>
</c:set>

<c:if test="${someproperty == 'st'}">
    ...
</c:if>