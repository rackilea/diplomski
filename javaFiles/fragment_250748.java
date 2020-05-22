<c:forEach var="entry" items="${resource}">
<tr>
    <td>${entry.key}</td>
    <td><input type = "text" name = "${entry.key}" value = "${entry.value}"></td>                           
</tr>
</c:forEach>