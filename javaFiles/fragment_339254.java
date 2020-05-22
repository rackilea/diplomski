<td id="enableOrDisableLink">
    <c:if test="${aUser.enabled}">
        <a href='disableUser/${aUser.id}'>Disable Account</a>
    </c:if>
    <c:if test="${not aUser.enabled}">
        <a href='enableUser/${aUser.id}'>Enable Account</a>
    </c:if>
</td>